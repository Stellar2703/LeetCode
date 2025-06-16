if __name__ == '__main__':
    N = int(input())
    lst = []
    for _ in range(N):
        func, *args = input().split()
        if func != 'print':
            getattr(lst, func)(*map(int, args))
        else:
            print(lst)


# The getattr() function in Python is used to dynamically access attributes or methods of an object using a string.

# Syntax:
# getattr(object, name[, default])  
# Parameters:
# - object: The object whose attribute or method you want to access.
# - name: The name of the attribute or method you want to access (as a string).
# - default: (Optional) A default value to return if the attribute or method is not found.

#The *map(int, args) part is doing two things:
# 1. It converts each element in the args list from a string to an integer.
# 2. It unpacks the resulting list of integers as separate arguments to the method being called on lst.

# The * unpacks the values from the map object so they can be passed as separate arguments to a function.
# Without the *, you'd pass a single iterable instead of multiple arguments.

