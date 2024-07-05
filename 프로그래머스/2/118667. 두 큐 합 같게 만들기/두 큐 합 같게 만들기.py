from collections import deque
def solution(queue1, queue2):
    answer = -1
    n = len(queue1) + len(queue2)
    one = sum(queue1)
    two = sum(queue2)
    target = (one + two) / 2
    left = target - one
    right = target - two
    q1 = deque(queue1)
    q2 = deque(queue2)
    cnt = 0
    while q1 and q2:
        if left == 0 and right == 0:
            answer = cnt
            break
        if cnt > 2 * n:
            break
        if left > right:
            out = q2.popleft()
            left -= out
            right += out
            q1.append(out)
            cnt += 1
        elif left < right:
            out = q1.popleft()
            left += out
            right -= out
            q2.append(out)
            cnt += 1
            
    
    return answer