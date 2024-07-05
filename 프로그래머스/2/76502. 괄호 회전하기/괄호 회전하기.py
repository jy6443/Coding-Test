from collections import deque
def solution(s):
    n = len(s)
    q = deque(s)
    answer = 0
    
    def test(que):
        dic = {")" : "(", "}" : "{", "]" : "["}
        cur_q = deque()
        for x in que:
            if not cur_q:
                cur_q.append(x)
            else:
                if x in dic and dic[x] == cur_q[-1]:
                    cur_q.pop()
                else:
                    cur_q.append(x)
        if not cur_q:
            return 1
        else:
            return 0
        
            
    for i in range(n):
        q.rotate(-1)
        que = list(q)
        answer += test(que)
    
    return answer
