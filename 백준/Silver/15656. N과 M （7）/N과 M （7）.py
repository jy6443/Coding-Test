import sys
sys.setrecursionlimit(10**5)
input = sys.stdin.readline
n, m = map(int,input().split())
lst = list(map(int,input().split()))
lst.sort()

def dfs(dep,l):
    if dep == m:
        print(*l)
        return

    for x in lst:
        l.append(x)
        dfs(dep+1,l)
        l.pop()

dfs(0,[])