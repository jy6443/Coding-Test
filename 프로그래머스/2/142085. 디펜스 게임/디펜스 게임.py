from heapq import heappop, heappush
def solution(n, k, enemy):
    answer = 0
    h = []

    for i,v in enumerate(enemy):
        n -= v
        heappush(h,(-1*v))
        
        if n < 0 :
            if k > 0:
                chance = -heappop(h)
                n += chance 
                k -= 1
                answer = i+1
            else:
                answer = i 
                break
        else:
            answer = i+1 
            
    return answer