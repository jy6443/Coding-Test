import sys
import heapq
input = sys.stdin.readline

n, m = map(int, input().split()) # n=집 10^5 / m=길 10^6

data = {i:[] for i in range(1,n+1)}

for i in range(m):
    a,b,c = map(int, input().split())
    data[a].append((c,b))
    data[b].append((c,a))



total = []
cnt = 0
visit = [False] * (n+1)
h = [(0,1)]
while h:
    cost, node = heapq.heappop(h)
    if(cnt == n):
        break
    if visit[node]:
        continue
    
    total.append(cost)
    cnt += 1
    visit[node] = True

    for next_cost, next_node in data[node]:
        if not visit[next_node]:
            heapq.heappush(h,[next_cost,next_node])

print(sum(total) - max(total))