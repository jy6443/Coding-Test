def solution(k, d):
    answer = 0
    # x * x + y * y = d * d
    x = 0
    while x <= d:
        # y = 0
        y = int((d ** 2 - x ** 2) ** (0.5))
        answer += ((y // k) + 1)
        x += k
    return answer