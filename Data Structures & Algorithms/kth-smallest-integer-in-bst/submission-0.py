# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        # First way would be sorting the elements by inorder traversal and then just go to kth element 
        # can we know the root position ? dont think so
        #can you do in order traversal ? I should try
        res = []
        def inorder(root):
            nonlocal res
            if not root:
                return
         
            inorder(root.left)
            res.append(root.val)
            inorder(root.right)
        inorder(root)
        return res[k-1]

        