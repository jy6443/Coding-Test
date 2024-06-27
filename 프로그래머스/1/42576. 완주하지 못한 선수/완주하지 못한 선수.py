def solution(participant, completion):
    dic = {}
    np = len(participant)
    nc = len(completion)
    
    for i in range(np):
        if participant[i] not in dic:
            dic[participant[i]] = 1
        else:
            dic[participant[i]] += 1
    
    for j in range(nc):
        dic[completion[j]] -= 1
        
    for k,v in dic.items():
        if v == 1:
            answer = k
            break
    return answer