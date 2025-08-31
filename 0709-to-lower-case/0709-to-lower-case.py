class Solution:
    def toLowerCase(self, s: str) -> str:
        result = ""
        for ch in s:
            # Check if character is uppercase A-Z
            if 'A' <= ch <= 'Z':
                # Convert to lowercase using ASCII values
                result += chr(ord(ch) + 32)
            else:
                result += ch
        return result
