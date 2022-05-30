class GraphNode:
    def __init__(self):
        self.in_degree = 0
        self.out_edges = []

class Solution:
    def minimumSemesters(self, n: int, relations: List[List[int]]) -> int:
        graph = defaultdict(GraphNode)
        total_edges = 0   
        for prev_course, next_course in relations:
            graph[prev_course].out_edges.append(next_course)
            graph[next_course].in_degree += 1
            total_edges += 1
            
        queue = []
        for course, node in graph.items():         
             if node.in_degree == 0:
                queue.append(course)
        if len(queue) == 0:
            return -1
        print(queue)
        count = 0
        edges_removed = 0
        while queue:
            count += 1
            queue_size = len(queue)
            for i in range(queue_size):
                current = queue.pop(0)
                for neighbor in graph[current].out_edges:
                    graph[neighbor].in_degree -= 1
                    edges_removed += 1
                    if graph[neighbor].in_degree == 0:
                        queue.append(neighbor)
            
            
        
        return count if total_edges == edges_removed else -1
