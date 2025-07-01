# swapping numbers using function
def swap_numbers(a, b):
    """
    This function swaps two numbers and returns them.
    
    Parameters:
    a (int, float): The first number.
    b (int, float): The second number.
    
    Returns:
    tuple: A tuple containing the swapped numbers (b, a).
    """
    return b, a
# Example usage
if __name__ == "__main__":
    num1 = 5
    num2 = 10
    swapped = swap_numbers(num1, num2)
    print(f"Original numbers: {num1}, {num2}")
    print(f"Swapped numbers: {swapped[0]}, {swapped[1]}")
# This code defines a function to swap two numbers and demonstrates its usage.
# The function takes two numbers as input and returns them in swapped order.