def factHead(num):
    if num == 0:
        return 1
    small_problem = factHead(num-1)
    ans = num * small_problem
    return num

def factTailWrong(num):
    if num == 0:
        return 1
    return num*factTailWrong(num-1)
# this is not a tail recursion
# in fact a recursion is said to be a tail rescursion if the recusrsion
# does not involve any caluculation in it 

def factTail(num, accumulator = 1):
    if num == 0:
        return accumulator
    accumulator*=num

    return factTail(num-1,accumulator)

# in this in the line 21 it is clear that the recursice call does not involve any calculation 
# hence this is called an tail recursion


