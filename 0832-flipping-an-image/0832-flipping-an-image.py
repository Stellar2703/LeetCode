class Solution:
    def flipAndInvertImage(self, image: List[List[int]]) -> List[List[int]]:
        for row in image:
            # Two pointers: left and right
            l, r = 0, len(row) - 1
            while l <= r:
                # Swap and invert in one step
                row[l], row[r] = row[r] ^ 1, row[l] ^ 1
                l += 1
                r -= 1
        return image

        