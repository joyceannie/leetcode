class GraphNode:
    def __init__(self):
        self.in_degree = 0
        self.out_edges = []
        
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        graph = defaultdict(GraphNode)
        total_edges = 0
        for next_course, prev_course in prerequisites:
            graph[next_course].in_degree += 1
            graph[prev_course].out_edges.append(next_course)
            total_edges += 1
        
        courses_without_prereq = []
        for course, node in graph.items():
            if node.in_degree == 0:
                courses_without_prereq.append(course)
        
        removed_edges = 0
        while courses_without_prereq:
            course = courses_without_prereq.pop()
            for next_course in graph[course].out_edges:
                graph[next_course].in_degree -= 1
                removed_edges += 1
                if graph[next_course].in_degree == 0:
                    courses_without_prereq.append(next_course)
        
        return total_edges == removed_edges
