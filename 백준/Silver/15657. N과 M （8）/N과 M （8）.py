import sys
input = sys.stdin.readline
n, m = map(int,input().split())
lst = list(map(int,input().split()))
lst.sort()

answer = []

def dfs(i,dep,l):
    if dep == m:
        print(*l)
        return

    for x in lst:
        if x >= i:
            l.append(x)
            dfs(x,dep+1,l)
            l.pop()

dfs(lst[0],0,[])