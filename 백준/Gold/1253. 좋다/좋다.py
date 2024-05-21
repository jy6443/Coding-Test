import sys
input = sys.stdin.readline

N = int(input())
arr = list(map(int, input().split()))
arr.sort()  

cnt = 0

for k in range(N):
    now = arr[k]

    left, right = 0, N-1
    while left < right:
        if arr[left] + arr[right] == now:
            if left == k:
                left += 1
            elif right == k:
                right -= 1
            else:
                cnt += 1
                break
        elif arr[left] + arr[right] > now:
            right -= 1
        else:
            left += 1

print(cnt)