if __name__ == '__main__':
    li = []
    for _ in range(int(input())):
        name = input()
        score = float(input())
        li.append([name,score])
        
    sec = sorted(set([scores for names,scores in li]))[1]
    print('\n'.join(sorted([name for name, score in li if score == sec])))