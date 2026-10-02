class Solution:
    def maximum(self, mat):
        maximum = mat[0][0]

        for row in mat:
            for value in row:
                if value > maximum:
                    maximum = value

        return maximum
