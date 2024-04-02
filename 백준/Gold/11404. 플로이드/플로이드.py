import sys
input = sys.stdin.readline
n = int(input())
m = int(input())
INF = 987654321
bus = [[INF] * (n+1) for _ in range(n+1)]
for i in range(1,n+1):
    bus[i][i] = 0
for _ in range(m):
    a,b,c = map(int,input().split())
    bus[a][b] = min(bus[a][b],c)

for i in range(1,n+1):
    for j in range(1,n+1):
        if j == i:
            continue
        for k in range(1,n+1):
            bus[j][k] = min(bus[j][k],bus[j][i]+bus[i][k])

for row in bus[1:]:
    for i in range(1,n+1):
        if row[i] == INF:
            row[i] = 0
    print(*row[1:])