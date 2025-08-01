class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        def bin_row(target):
            l,r = 0,len(matrix)-1
            while l <= r:
                m = (l+r)//2
                if matrix[m][0]>target:
                    r = m - 1
                elif matrix[m][0]<target:
                    l = m +1
                else:
                    return m
            return r

        def bin_col(target,row):
            l,r = 0,len(matrix[0])-1
            while l <= r:
                m = (l+r)//2
                if matrix[row][m]>target:
                    r = m - 1
                elif matrix[row][m]<target:
                    l = m + 1
                else:
                    return True
            return False
        
        row = bin_row(target)
        # col = bin_col(target,row)
        # a = matrix[row][col]
        # print(row,col,a)
        # if a == target:
        #     return True
        # else:
        #     return False

        if bin_col(target,row):
            return True
        else:
            return False