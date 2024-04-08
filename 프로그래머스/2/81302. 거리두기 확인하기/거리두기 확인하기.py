def solution(places):
    answer = []
    
    for place in places:
        place = [list(i) for i in place]
        check = True
        
        for y in range(5):
            if not check:
                break
            for x in range(5): # 우하단만 체크
                if place[y][x] == 'P':
                    if x < 4:
                        if place[y][x+1] == 'P':
                            check = False
                        elif place[y][x+1] == 'O' and (x < 3 and place[y][x+2] == 'P'):
                            check = False
                    if y < 4:
                        if place[y+1][x] == 'P':
                            check = False
                        elif place[y+1][x] == 'O' and (y < 3 and place[y+2][x] == 'P'):
                            check = False
                    if x < 4 and y > 0:
                        if place[y-1][x+1] == 'P' and (place[y][x+1] == 'O' or place[y-1][x] == 'O'):
                            check = False
                    if x < 4 and y < 4:
                        if place[y+1][x+1] == 'P' and (place[y][x+1] == 'O' or place[y+1][x] == 'O'):
                            check = False
        if check:
            answer.append(1)
        else:
            answer.append(0)
    return answer