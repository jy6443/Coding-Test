from collections import deque
def solution(maps):
    q = deque()
    dx = [1,0,-1,0]
    dy = [0,-1,0,1]
    m = len(maps)
    n = len(maps[0])
    q.append((0,0))
    visit = [[0] * (n) for _ in range(m)]
    
    while q:
        x,y = q.popleft()
        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]
            if 0 <= nx < m and 0 <= ny < n and maps[nx][ny] == 1 and visit[nx][ny] == 0:
                visit[x+dx[i]][y+dy[i]] = 1
                q.append((x+dx[i],y+dy[i]))
                maps[x+dx[i]][y+dy[i]] = maps[x][y] + 1
                
    if maps[m-1][n-1] == 1:
        return -1
    else:
        return maps[m-1][n-1]
    # return maps
    # return dfs(maps,1,1,m,n,visit)
    