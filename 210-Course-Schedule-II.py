class GraphNode:
    def __init__(self):
        self.in_degree = 0
        self.out_edges = []
        
class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        if not prerequisites:
            return [i for i in range(numCourses)]
        
        graph = defaultdict(GraphNode)
        for next_course, current_course in prerequisites:
            graph[next_course].in_degree += 1
            graph[current_course].out_edges.append(next_course)
        
        courses_without_prereq = []
        for course in range(numCourses):
            if graph[course].in_degree == 0:
                courses_without_prereq.append(course)
        
        order_of_courses = []
        while courses_without_prereq:
            course = courses_without_prereq.pop()
            for next_course in graph[course].out_edges:
                graph[next_course].in_degree -= 1
                if graph[next_course].in_degree == 0:
                    courses_without_prereq.append(next_course)
            order_of_courses.append(course)
        
        return order_of_courses if len(order_of_courses) == numCourses else []
