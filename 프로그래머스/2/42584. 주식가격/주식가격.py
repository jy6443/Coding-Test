# from collections import deque
def solution(prices):
    n = len(prices)
    # enter = deque()
    answer = []
    for i in range(n):
        time = 0
        j = i + 1
        while j < n:
            time += 1
            if prices[i] > prices[j]:
                break
            else:
                j += 1
        answer.append(time)
    return answer