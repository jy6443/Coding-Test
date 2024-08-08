# 네트워크 연결
import sys
input = sys.stdin.readline
import heapq
answer = 1000000
n = int(input()) # 1 <= n <= 1,000
m = int(input()) # 1 <= m <= 100,000
node = {i:[] for i in range(1,n+1)}
for _ in range(m):
    a,b,c = map(int, input().split())
    node[a] += [[b,c]]
    node[b] += [[a,c]]

def heap(start):
    visit = [False] * (n+1)
    h = [(0,start)]
    total = 0
    cnt = 0

    while h and cnt < n:
        out = heapq.heappop(h)
        cost = out[0]
        vertex = out[1]
        if(visit[vertex] == False):
            visit[vertex] = True
            total += cost
            cnt += 1
            for next_vertex, next_cost in node[vertex]:
                if(visit[next_vertex] == False):
                    heapq.heappush(h,(next_cost,next_vertex))
    return total


print(heap(1))