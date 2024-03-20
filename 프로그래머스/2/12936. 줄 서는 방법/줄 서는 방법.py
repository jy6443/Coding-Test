def solution(n, k):
    answer = []
    num = list(range(1,n+1))
    dp = [0] * (n+1)
    dp[0], dp[1] = 1, 1
    for i in range(2,n+1):
        dp[i] = dp[i-1] * i
        
    s = n-1
    while num:
        per = (k-1) // dp[s]
        answer.append(num.pop(per))
        k = k % dp[s]
        s -= 1
    return answer