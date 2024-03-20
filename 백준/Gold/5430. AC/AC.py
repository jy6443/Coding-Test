import sys
from collections import deque
input = sys.stdin.readline
t = int(input())

for _ in range(t):
    p = input().rstrip() # 수행할 함수
    n = int(input()) # 배열 수
    arr = deque(input().rstrip()[1:-1].split(','))

    if n == 0:
        arr = deque()

    err = False
    t = 0
    for alp in p:
        if alp == 'R':
            t = t ^ 1
        else:
            if arr:
                if t == 0:
                    arr.popleft()
                else:
                    arr.pop()
            else:
                err = True
                break
    
    if err:
        print('error')
    else:
        if t == 1:
            arr.reverse()
        print('['+','.join(arr)+']')