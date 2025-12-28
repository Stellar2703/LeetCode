# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def f(self,root,ans):
        if root == None:
            return 
        self.f(root.left,ans)
        ans.append(root.val)
        self.f(root.right,ans)
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        ans = []
        self.f(root,ans)
        return ans
        