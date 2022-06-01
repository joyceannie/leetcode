class Solution:
    def copyRandomBinaryTree(self, root: 'Optional[Node]') -> 'Optional[NodeCopy]':
        mapping = {}
        
        def helper(root):
            if root is None:
                return root
            if root in mapping:
                return mapping[root]
            
            node_copy = NodeCopy(root.val)
            mapping[root] = node_copy
            
            node_copy.left = helper(root.left)
            node_copy.right = helper(root.right)
            node_copy.random = helper(root.random)
            
            return node_copy
        
        return helper(root)
