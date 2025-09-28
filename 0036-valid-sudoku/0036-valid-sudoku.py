from typing import List

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        def checkrow(board):
            for row in board:
                seen = [False] * 10
                for val in row:
                    if val == '.':
                        continue
                    num = int(val)
                    if seen[num]:
                        return False
                    seen[num] = True
            return True

        def checkcolumn(board):
            for col in range(9):
                seen = [False] * 10
                for row in range(9):
                    val = board[row][col]
                    if val == '.':
                        continue
                    num = int(val)
                    if seen[num]:
                        return False
                    seen[num] = True
            return True

        def checkbox(board):
            for start_row in range(0, 9, 3):
                for start_col in range(0, 9, 3):
                    seen = [False] * 10
                    for i in range(3):
                        for j in range(3):
                            val = board[start_row + i][start_col + j]
                            if val == '.':
                                continue
                            num = int(val)
                            if seen[num]:
                                return False
                            seen[num] = True
            return True

        return checkrow(board) and checkcolumn(board) and checkbox(board)
