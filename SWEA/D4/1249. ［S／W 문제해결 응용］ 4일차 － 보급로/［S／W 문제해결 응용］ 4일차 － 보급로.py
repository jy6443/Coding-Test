from collections import deque

T = int(input())

dx = [1,0,-1,0]
dy = [0,1,0,-1]

def bfs():
    global visit
    q = deque()
    q.append((0,0))
    visit[0][0] = 0
    while q:
        y,x = q.popleft()
        for i in range(4):
            ny = y + dx[i]
            nx = x + dy[i]
            if 0 <= ny < n and 0 <= nx < n:
                if visit[ny][nx] == -1:
                    visit[ny][nx] = visit[y][x] + maps[ny][nx]
                    q.append((ny,nx))
                else:
                    if visit[ny][nx] > visit[y][x] + maps[ny][nx]:
                        visit[ny][nx] = visit[y][x] + maps[ny][nx]
                        q.append((ny, nx))


for tc in range(1,T+1):
    n = int(input())
    maps = []
    for _ in range(n):
        maps.append(list(map(int,input())))
    start_x, start_y = 0, 0
    end_x, end_y = n-1, n-1

    visit = [[-1]*n for _ in range(n)]

    bfs()
    print("#{} {}".format(tc,visit[-1][-1]))