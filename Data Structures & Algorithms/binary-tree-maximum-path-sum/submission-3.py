# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        maxP = float('-inf')
        def dfs(root):
            nonlocal maxP
            if not root:
                return 0
            left  = dfs(root.left)
            right = dfs(root.right)
            maxP = max(maxP,root.val + left + right, root.val, root.val + left , root.val+right)

            return root.val + max(left,right,0)
        dfs(root)
        return maxP