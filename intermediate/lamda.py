def func(x):
    return x+5

func2 = lambda x: x + 5

a = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

new_list = list(map(lambda x : x+5, a))
new_list1 = list(filter(lambda x : x%2==0, a))
print(new_list)
print(new_list1)