import sys
input = sys.stdin.readline

n = int(input()) # 1 <= n <= 1000 이중포문까지 가능
data = []
answer = [0] * (1001)
for _ in range(n):
    data.append(list(map(int,input().split())))

data.sort(key=lambda x:-x[1])
for i in range(n):
    reward = data[i][1]
    day = data[i][0]
    while day > 0 and answer[day] > 0:
        day-=1
    if day > 0:
        answer[day] = reward

print(sum(answer))