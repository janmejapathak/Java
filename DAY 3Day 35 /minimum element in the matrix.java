class Solution:
    def minimum(self, mat):
        minimum = mat[0][0]

        for row in mat:
            for value in row:
                if value < minimum:
                    minimum = value

        return minimum
