def sum_num(n):
    if n == 1:
        return 1
    small_problem = sum_num(n-1)

    ans = n + small_problem

    return ans

print(sum_num(10))