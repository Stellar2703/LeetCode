# optinal parameters


def func(x=1): # Where x=1 acts as an optional parameter
    return x**2 

def func1(word, freq=2,add=3): # Where y=2 acts as an optional parameter
    print(word*(freq+add))


call = func1('hello', 3, 4) # Here we are passing the optional parameters freq and add



