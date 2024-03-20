from collections import deque
def solution(N, road, K):
    answer = 0
    maps = {i:[] for i in range(1,N+1)}
    for arr in road:
        a,b,cost = arr[0],arr[1],arr[2]
        maps[a].append([b,cost])
        maps[b].append([a,cost])
        
    visit = [987654321] * (N+1)
    
    def bfs(visit):
        
        q = deque()
        q.append(1)
        visit[1] = 0
        while q:
            out = q.popleft()
            for lst in maps[out]:
                node, dist = lst[0], lst[1]
                if visit[node] > visit[out] + dist:
                    visit[node] = visit[out] + dist
                    q.append(node)
                    
        return 
    
    bfs(visit)     
    for x in visit[1:]:
        if x <= K:
            answer += 1
            
    return answer