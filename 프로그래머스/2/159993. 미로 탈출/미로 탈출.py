from collections import deque
def solution(maps):
    answer = 0
    rows = len(maps)
    cols = len(maps[0])
    start = []
    end = []
    lever = []
    maps = [list(s) for s in maps]
    for i in range(rows):
        for j in range(cols):
            if maps[i][j] == 'S':
                start += [i,j]
            if maps[i][j] == 'E':
                end += [i,j]
            if maps[i][j] == 'L':
                lever += [i,j]
    
    dx = [1,0,-1,0]
    dy = [0,-1,0,1]
    
    def bfs(s,e):
        s_x, s_y = s[1], s[0]
        e_x, e_y = e[1], e[0]
        visit = [[0] * (cols) for _ in range(rows)]
        q = deque()
        q.append((s_y,s_x))
        answer = -1
        cna = False
        while q:
            y, x = q.popleft()
            if y == e_y and x == e_x:
                answer = visit[y][x]
                can = True
                break
            for i in range(4):
                ny = y + dy[i]
                nx = x + dx[i]
                if 0 <= ny < rows and 0 <= nx < cols:
                    if maps[ny][nx] != 'X':
                        if visit[ny][nx] == 0:
                            visit[ny][nx] = visit[y][x]+1
                            q.append((ny,nx))
    
        return answer

    a = bfs(start,lever)
    b = bfs(lever,end)
    
    if a == -1 or b == -1:
        return -1
    else:
        return a + b
    
        
        
        
        
        
        
    
    
    
    
    # return lever