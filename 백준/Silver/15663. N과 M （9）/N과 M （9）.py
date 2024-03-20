import sys
input = sys.stdin.readline
n, m = map(int,input().split())
lst = list(map(int,input().split()))
lst.sort()

visit = [False] * n
def dfs(dep,l):
    if dep == m:
        print(*l)
        return
    before = 0
    for i in range(n):
        if not visit[i] and lst[i] != before:
            visit[i] = True
            before = lst[i]
            dfs(dep+1,l+[lst[i]])
            visit[i] = False
    

dfs(0,[])