import copy
def solution(n, results):
    answer = 0
    w = {i:[] for i in range(1,n+1)}
    l = {i:[] for i in range(1,n+1)}
    for result in results:
        a,b = map(int,result)
        w[a] += [b]
        l[b] += [a]
    
    
    def dfs(k,p):
        visit = [False] * (n+1)
        visit[k] = True
        s = []
        for i in p[k]:
            visit[i] = True
            s.append(i)
        while s:
            out = s.pop()
            for x in p[out]:
                if not visit[x]:
                    visit[x] = True
                    p[k] += [x]
                    s.append(x)
       

    for k in range(1,n+1):
        dfs(k,w)
        dfs(k,l)
            
    for player in range(1,n+1):
        if len(w[player]) + len(l[player]) == n-1:
            answer += 1
    
    return answer