import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

def dfs(i,dep):
    global stop
    if stop:
        return 
    if dep == 5:
        stop = True
        return
    visit[i] = 1
    for val in maps[i]:
        if visit[val] == 0:
            dfs(val,dep+1)
    visit[i] = 0
    
n, m = map(int, input().split())
maps = {i:[] for i in range(n)}

for _ in range(m):
    a, b = map(int,input().split())
    maps[a] += [b]
    maps[b] += [a]

stop = False
visit = [0] * n
for i in range(n):
    dfs(i,1)
    if stop:
        break

if stop:
    print(1)
else:
    print(0)

