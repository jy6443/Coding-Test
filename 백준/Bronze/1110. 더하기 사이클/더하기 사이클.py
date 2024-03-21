import sys

input = sys.stdin.readline
n = int(input())
num = n
cnt = 1
while True:
    a,b = n//10, n%10
    c = (a+b) % 10
    n = b * 10 + c
    if n == num:
        print(cnt)
        break
    else:
        cnt += 1