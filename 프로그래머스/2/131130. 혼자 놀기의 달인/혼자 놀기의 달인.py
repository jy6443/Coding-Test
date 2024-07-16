import sys
sys.setrecursionlimit(10 ** 6)
def dfs(idx,now,total,visit,cards):
    num = cards[idx] - 1
    if(visit[num] == False):
        visit[num] = True
        now.append(num)
        dfs(num,now,total,visit,cards)
    else:
        total.append(now)
        return

def solution(cards):
    answer = 0
    visit = [False] * len(cards)
    total = []
    for i in range(len(cards)):
        now = []
        if(visit[i]==False):
            visit[i] = True
            now.append(i)
            dfs(i,now,total,visit,cards)
    total.sort(key = lambda x : len(x), reverse = True)
    if len(total) < 2:
        return 0
    else:
        return len(total[0]) * len(total[1])