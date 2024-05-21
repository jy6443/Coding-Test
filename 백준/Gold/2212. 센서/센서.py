import sys
input = sys.stdin.readline

n = int(input())
k = int(input())

sesor = list(map(int,input().split()))
sesor.sort()
distance = []
for i in range(n-1):
    distance.append(sesor[i+1] - sesor[i])

distance.sort(reverse=True)
total = sum(distance[k-1:])
print(total)