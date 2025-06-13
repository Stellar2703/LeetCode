# Syntax: *line = iterable
# The * operator in assignment is used for unpacking.

# It tells Python: "grab everything else here and put it in line as a list."


if __name__ == '__main__':
    n = int(input())
    student_marks = {}
    sum = 0
    for _ in range(n):
        name, *line = input().split()
        scores = list(map(float, line))
        student_marks[name] = scores
    query_name = input()
    for i in student_marks[query_name]: 
        sum += i
    (avg) = sum/3
    print("%.2f" % avg)
    
    