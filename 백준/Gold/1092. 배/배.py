# 배
import sys
input = sys.stdin.readline

n = int(input()) # 1 <= n <= 50
weight = list(map(int, input().split()))
m = int(input()) # 1 <= m <= 10,000
box = list(map(int, input().split()))

weight.sort(reverse=True)
box.sort(reverse=True)

if box[0] > weight[0]:
    print(-1)
else:
    t = 0
    while box:
        for w in weight:
            if(box and w < box[-1]):
                weight.remove(w)
                continue
            for i in range(len(box)):
                if(w >= box[i]):
                    box.remove(box[i])
                    break
        t+=1
    print(t)