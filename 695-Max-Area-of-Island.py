class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        rows, cols = len(grid), len(grid[0])
        visited = set()
        area = 0
        
        def dfs(row, col):
            if row not in range(rows) or col not in range(cols) or grid[row][col] != 1 or (row, col) in visited:
                return 0
            visited.add((row, col))
            return 1 + dfs(row +1, col) + dfs(row - 1, col) + dfs(row, col + 1) + dfs(row, col - 1)
        
        for row in range(rows):
            for col in range(cols):
                if grid[row][col] == 1 and (row, col) not in visited:
                    area = max(area, dfs(row, col))
        return area
