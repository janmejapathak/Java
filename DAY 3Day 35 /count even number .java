class Solution:
    def countEven(self, mat):
        count = 0

        for row in mat:
            for value in row:
                if value % 2 == 0:
                    count += 1

        return count
