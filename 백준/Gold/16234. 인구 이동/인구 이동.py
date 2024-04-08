import sys
from collections import deque
input = sys.stdin.readline
N, L, R = map(int,input().split())
A = []
for i in range(N):
    A.append(list(map(int,input().split())))

dx = [1,0,-1,0]
dy = [0,1,0,-1]

def bfs(i,j):
    q = deque()
    q.append((i,j))
    country = []
    country.append((i,j))
    while q:
        y,x = q.popleft()
        for k in range(4):
            ny = y + dy[k]
            nx = x + dx[k]
            if 0 <= nx < N and 0 <= ny < N and visit[ny][nx] == -1:
                if L <= abs(A[y][x] - A[ny][nx]) <= R:
                    q.append((ny,nx))
                    visit[ny][nx] = 1
                    country.append((ny,nx))

    return country

day = 0

while True:
    visit = [[-1] * N for _ in range(N)]
    flag = 0
    for r in range(N):
        for c in range(N):
            if visit[r][c] == -1:
                visit[r][c] = 1
                lst = bfs(r,c)

                if len(lst) > 1:
                    flag = 1
                    exp = 0
                    for a,b in lst:
                        exp += A[a][b]
                    exp = exp // len(lst)
                    for a,b in lst:
                        A[a][b] = exp
    if flag == 0:
        break
    day += 1

print(day)
