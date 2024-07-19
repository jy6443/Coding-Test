def solution(begin, target, words):
    n = len(words)
    visit = [0] * n
    q = []
    
    if target  not in words:
        key = -1
        return 0
    else:
        l = len(begin)
        q.append([begin,0])
        while q:
            x,dep = q.pop(0)
            answer = dep
            if x == target:
                break
            
            for i in range(n):
                cnt = 0
                if visit[i] == 0:
                    for j in range(l):
                        if words[i][j] == x[j]:
                            cnt += 1
                    if cnt == l-1:
                        q.append([words[i],dep+1])
                        visit[i] == 1
                    
        
        return answer
    