class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:

        s1_length, s2_length = len(s1), len(s2)
      
        # If the s1 is longer than the s2, the inclusion is not possible
        if s1_length > s2_length:
            return False
      
        # Initialize a counter for the characters in both strings
        char_counter = Counter()
      
        # Decrease the count for s1 characters and increase for the first window in s2
        for s1_char, s2_char in zip(s1, s2[:s1_length]):
            char_counter[s1_char] -= 1
            char_counter[s2_char] += 1
      
        # Calculate the number of characters that are different
        diff_count = sum(x != 0 for x in char_counter.values())
      
        # If no characters are different, we found an inclusion
        if diff_count == 0:
            return True
      
        # Slide the window over s2, one character at a time
        for i in range(s1_length, s2_length):
            # Get the character that will be removed from the window and the one that will be added
            char_out = s2[i - s1_length]
            char_in = s2[i]
          
            # Update diff_count if the incoming character impacts the balance
            if char_counter[char_in] == 0:
                diff_count += 1
            char_counter[char_in] += 1
            if char_counter[char_in] == 0:
                diff_count -= 1
          
            # Update diff_count if the outgoing character impacts the balance
            if char_counter[char_out] == 0:
                diff_count += 1
            char_counter[char_out] -= 1
            if char_counter[char_out] == 0:
                diff_count -= 1
          
            # If no characters are different, we have found an inclusion
            if diff_count == 0:
                return True
      
        # If inclusion has not been found by the end of the s2, return False
        return False