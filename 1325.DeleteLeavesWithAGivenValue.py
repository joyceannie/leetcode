# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def removeLeafNodes(self, root: Optional[TreeNode], target: int) -> Optional[TreeNode]:
        def process_node(node, parent = None):
            if node is None:
                return
            process_node(node.right, node)
            process_node(node.left, node)
            if node.left is None and node.right is None:
                if node.val == target:
                    if parent is None:
                        node = None
                    else:
                        if parent.left == node:
                            parent.left = None
                        else:
                            parent.right = None
            return node
        
        return process_node(root)
