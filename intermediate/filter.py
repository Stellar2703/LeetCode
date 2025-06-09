def add7(x):
    return x + 7

def isOdd(x):
    return x % 2 != 0

li = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

# Using filter function to apply isOdd to each element in li
b= list(filter(isOdd, li))

c= list(map(add7, list(filter(isOdd, li))))

