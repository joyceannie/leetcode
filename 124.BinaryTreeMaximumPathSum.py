# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        
        def get_max_path_sum(node):
            nonlocal max_sum
            if not node:
                return 0
            
            left_path_sum=max(get_max_path_sum(node.left), 0)
            right_path_sum=max(get_max_path_sum(node.right), 0)
            
            current_sum = node.val +left_path_sum+right_path_sum
            max_sum = max(max_sum, current_sum)
            
            return node.val + max(left_path_sum, right_path_sum)
        
        max_sum = float('-inf')
        get_max_path_sum(root)
        return max_sum
