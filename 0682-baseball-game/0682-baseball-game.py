class Solution:
    def calPoints(self, operations: List[str]) -> int:
        """
        Calculate the sum of scores after applying all operations in a baseball game.
      
        Args:
            operations: List of strings representing operations to perform
      
        Returns:
            The sum of all valid scores after applying all operations
        """
        # Initialize stack to keep track of valid scores
        score_stack = []
      
        # Process each operation
        for operation in operations:
            if operation == "+":
                # Add sum of last two scores
                score_stack.append(score_stack[-1] + score_stack[-2])
            elif operation == "D":
                # Double the last score (using bit shift left by 1)
                score_stack.append(score_stack[-1] << 1)
            elif operation == "C":
                # Cancel/remove the last score
                score_stack.pop()
            else:
                # It's a number, convert string to integer and add to stack
                score_stack.append(int(operation))
      
        # Return the sum of all remaining valid scores
        return sum(score_stack)