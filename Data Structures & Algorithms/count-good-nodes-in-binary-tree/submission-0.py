# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        high = []
        count= 0
        def dfs(root):
            nonlocal count
            if not root:
                return
            if not high or root.val >= high[-1].val:
                count=count+1
                high.append(root)
            dfs(root.left)
            dfs(root.right)
            if root == high[-1]:
                high.pop()
        dfs(root)
        return count

        