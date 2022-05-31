class Solution:
    def getMaximumGold(self, grid: List[List[int]]) -> int:
        def dfs(row, col):
            if row < 0 or row >= m or col < 0 or col >= n or grid[row][col] == 0:
                return 0
            
            gold_collected = grid[row][col]
            grid[row][col] = 0
            ans = gold_collected + max(dfs(row+1, col), dfs(row-1, col), dfs(row, col+1), dfs(row, col-1))
            grid[row][col] = gold_collected
            return ans
        
        m, n = len(grid), len(grid[0])
        max_gold = 0
        for row in range(m):
            for col in range(n):
                if grid[row][col] > 0:
                    max_gold = max(max_gold, dfs(row, col))
        return max_gold
