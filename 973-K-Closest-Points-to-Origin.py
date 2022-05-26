class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        dist_from_origins = []
        for point in points:
            x = point[0]
            y = point[1]
            distance = math.sqrt(x*x + y*y)
            dist_from_origins.append([distance, x, y])
        
        heapq.heapify(dist_from_origins)
        k_nearest_points = []
        for i in range(k):
            dist, x, y = heapq.heappop(dist_from_origins)
            k_nearest_points.append([x, y])
        return k_nearest_points
