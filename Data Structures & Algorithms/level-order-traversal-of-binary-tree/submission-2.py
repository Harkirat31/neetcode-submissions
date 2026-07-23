# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        queue = []
        res = []
        if root:
            queue.append(root)
        while queue:
            levelNodes = len(queue)
            r = []
            while levelNodes>0:
                if queue:
                    ele = queue.pop(0)
                    r.append(ele.val)
                    if ele.left:
                        queue.append(ele.left)
                    if ele.right:
                        queue.append(ele.right)
                levelNodes -=1
            res.append(r)
        return res




        