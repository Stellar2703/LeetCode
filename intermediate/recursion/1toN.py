def numbers(n):
    if n <= 0:
        return
    numbers(n-1)
    print(n)
print(numbers(5))


def numbers(n):
    if n <= 0:
        return
    print(n)
    numbers(n-1)  # here the type of recursion used is Tail Recursion Try to imagine it vai memory
print(numbers(5))