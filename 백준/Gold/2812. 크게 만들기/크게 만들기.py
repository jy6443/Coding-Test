import sys
input = sys.stdin.readline
answer = []
n, k = map(int, input().split())
num = list(map(int,input().strip()))
stack = []
cnt = k
for i in num:
    while cnt > 0 and stack and stack[-1] < i:
        stack.pop()
        cnt -= 1
    stack.append(i)

print(''.join(map(str,stack[:n-k])))