class Solution:
    def boundarySum(self, mat):
        n = len(mat)
        total = 0

        for i in range(n):
            for j in range(n):
                if i == 0 or i == n - 1 or j == 0 or j == n - 1:
                    total += mat[i][j]

        return total
