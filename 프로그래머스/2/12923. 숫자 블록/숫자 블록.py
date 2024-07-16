import math
def cal(x):
    if x==1:
        return 0
    elif x==2 or x==3:
        return 1
    else:
        temp = []
        for i in range(2,int(math.sqrt(x))+1):
            if x%i == 0:
                temp.append(i)
                if x/i <= 10000000:
                    return x/i
        if len(temp) > 0:
            return temp[-1]
        else:
            return 1

def solution(begin, end):
    answer = []
    for num in range(begin,end+1):
        answer.append(cal(num))
    return answer
