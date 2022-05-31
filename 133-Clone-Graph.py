"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    
    def __init__(self):
        self.visited = {}
    
    def cloneGraph(self, node: 'Node') -> 'Node':
        if not node:
            return node
        
        if node in self.visited:
            return self.visited[node]
        
        cloned_node = Node(node.val, [])  
        self.visited[node] = cloned_node
        for neighbor in node.neighbors:
            cloned_node.neighbors.append(self.cloneGraph(neighbor))
            
        return cloned_node
