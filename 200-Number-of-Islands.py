class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        count = 0
        visited = set()
        m = len(grid)
        n = len(grid[0])
        
        def dfs(row, col):
            if row not in range(m) or col not in range(n) or grid[row][col] == '0' or (row, col) in visited:
                return
            
            visited.add((row, col))
            directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]
            for r, c in directions:
                new_row, new_col = row + r, col + c
                dfs(new_row, new_col)
                
        
        for row in range(m):
            for col in range(n):
                if grid[row][col] == '1' and (row, col) not in visited:
                    count += 1
                    dfs(row, col)
        
        return count
