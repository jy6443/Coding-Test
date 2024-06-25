def solution(n):
    answer = []
    n_list = list(map(int,str(n)))
    for i in range(len(n_list)-1,-1,-1):
        answer.append(n_list[i])
    return answer