import sys
from heapq import heappop, heappush
input = sys.stdin.readline
n = int(input())
m = int(input())
INF = 987654321
node = {i:[] for i in range(1,n+1)}
for i in range(m):
    a, b, c = map(int,input().split())
    node[a].append([b,c])
start, end = map(int, input().split())

def dijkstra(start,end):
    visit = [INF] * (n+1)
    h = []
    heappush(h,[0,start])
    visit[start] = 0

    while h:
        cost, num = heappop(h)
        if visit[num] < cost:
            continue

        for b,c in node[num]:
            next = visit[num] + c
            if visit[b] > next:
                heappush(h,[next,b])
                visit[b] = next
    
    return visit[end]


print(dijkstra(start,end))