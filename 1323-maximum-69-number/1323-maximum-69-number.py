class Solution:
    def maximum69Number (self, num: int) -> int:
        b=list(str(num))
        changed = False
        for i in range(len(b)):
            if b[i] == '6':
                b[i] = '9'
                changed = True
            if changed:
                return int("".join(b))
        return num