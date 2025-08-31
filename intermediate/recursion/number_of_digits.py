def num_of_digits(num):
    if num == 0:
        return 0
    
    small_problem = num_of_digits(num//10)

    ans = 1 + small_problem

    return ans

print(num_of_digits(9))