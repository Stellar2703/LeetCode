def fibo(index):
    if index == 1:
        return 1
    if index == 0:
        return 1
    
    small_problem = fibo(index-1) 
    second_small_problem = fibo(index-2)

    ans = small_problem + second_small_problem

    return ans
print(fibo(5))