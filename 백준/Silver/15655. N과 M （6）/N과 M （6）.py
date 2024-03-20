import sys
input = sys.stdin.readline
n, m = map(int,input().split())
lst = list(map(int,input().split()))
lst.sort()

answer = []
visit = {i:False for i in lst}

def dfs(i,dep,l,visit):
    if dep == m:
        answer.append(l)
    
    for x in lst:
        if x <= i:
            continue
        if not visit[x]:
            visit[x] = True
            dfs(x,dep+1,l+[x],visit)
            visit[x] = False 

    return

dfs(lst[0]-1,0,[],visit)

for arr in answer:
    print(*arr)