class Solution:
    def nextGreatestLetter(self, letters: List[str], target: str) -> str:
        start, end = 0, len(letters) - 1
        
        while start <= end:
            mid = (start + end) // 2
            if letters[mid] <= target:
                start = mid +1
            else:
                end = mid - 1
        print (start)
        return letters[start] if start < len(letters) else letters[0]