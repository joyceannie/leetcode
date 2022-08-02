class Solution:
    def countSquares(self, matrix: List[List[int]]) -> int:
        count = 0
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j] == 1:
                    count += 1
                    if i > 0 and j > 0 and matrix[i-1][j] > 0 and matrix[i-1][j-1] > 0 and  matrix[i][j-1] > 0:
                        min_value = min(matrix[i-1][j], matrix[i-1][j-1], matrix[i][j-1])
                        matrix[i][j] = 1 + min_value
                        count += min_value
        return count
