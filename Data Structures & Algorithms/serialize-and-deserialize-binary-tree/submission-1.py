# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Codec:
    
    # Encodes a tree to a single string.
    def serialize(self, root: Optional[TreeNode]) -> str:
        s = []
        q = deque()
        if not root:
            return ""
        q.append(root)
        while q:
            node = q.popleft()
            if node:
                s.append(str(node.val))
                q.append(node.left)
                q.append(node.right)
            else:
                s.append("N")
        return ",".join(s)

        
    # Decodes your encoded data to tree.

    def create(self,val):
        if val=="N":
            return None
        else:
            return TreeNode(int(val))


    def deserialize(self, data: str) -> Optional[TreeNode]:
        q = deque()
        s = []
        root=None
        if not len(data):
            return None

        s = data.split(",")
        
        root = self.create(s[0])
        q.append(root)

        i = 1
        while i<len(s) and q:
            node = q.popleft()
            if node:
                node.left = self.create(s[i])
                i+=1
                q.append(node.left)
                node.right = self.create(s[i] if i<len(s) else "N")
                q.append(node.right)
                i+=1
            
        return root

            
            
                


                















