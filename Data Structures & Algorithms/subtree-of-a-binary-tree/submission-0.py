# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:   
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        res = False
        def isSame(t1,t2):
            if not t1 and not t2:
                return True
            elif t1 and t2 and t1.val==t2.val:
                return isSame(t1.left,t2.left) and isSame(t1.right,t2.right)
            else:
                return False

        def dfs(root,subRoot):
            nonlocal res
            if root and root.val==subRoot.val:
                if isSame(root,subRoot):
                    res = True
                    return
            if not res and root:
                dfs(root.left,subRoot)
            if not res and root:
                dfs(root.right,subRoot)
        
        dfs(root,subRoot)

        return res
                    
                    



        