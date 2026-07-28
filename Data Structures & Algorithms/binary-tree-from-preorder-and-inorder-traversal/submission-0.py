# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if len(inorder)==0:
            return None
        mid = inorder.index(preorder[0])

        leftInorder = inorder[:mid] 
        rightInorder = inorder[mid+1:]

        leftPreorder = preorder[1:len(leftInorder)+1]
        rightPreorder = preorder[len(leftInorder)+1:]

        
        node = TreeNode(preorder[0])

        leftTree = self.buildTree(leftPreorder,leftInorder)
        rightTree = self.buildTree(rightPreorder,rightInorder)

        node.left = leftTree
        node.right = rightTree

        return node
        