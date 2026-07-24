# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        queue = []
        res = []

        if root:
            queue.append(root)

        while queue:
            l = len(queue)
            
            while l > 1:
                e = queue.pop(0)
                if e.left:
                    queue.append(e.left)
                if e.right:
                    queue.append(e.right)
                l=l-1
            node = queue.pop(0)
            res.append(node.val)
            if node.left:
                queue.append(node.left)
            if node.right:
                queue.append(node.right)
        return res
            

        