# map function

li = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

def func(x):
    return x**2

# Using map function to apply func to each element in li
print(list(map(func,li)))

# using list comprehension to achieve the same result
print(func(x) for x in li)

#normal metjod to achieve the same result
for x in li:
    print(func(x))

    