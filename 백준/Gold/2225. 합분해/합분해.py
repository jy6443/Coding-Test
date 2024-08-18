# 합 분해
import sys
input = sys.stdin.readline

token = 10**9
n, k = map(int, input().split()) # n<=200 / k<=200

dp = [[0] * (k+1) for _ in range(n+1)]

dp[0][0] = 1

for i in range(n+1):
    for j in range(1,k+1):
        dp[i][j] = dp[i][j-1]
        if i > 0:
            dp[i][j] += dp[i-1][j]

print(dp[n][k] % token)