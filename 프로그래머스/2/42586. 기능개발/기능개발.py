def solution(progresses, speeds):
    answer = []
    arr = []
    
    for i in range(len(progresses)):
        if (100 - progresses[i]) % speeds[i] == 0:
            arr.append(int((100 - progresses[i]) // speeds[i]))
        else:
            arr.append(int(((100 - progresses[i]) // speeds[i])+1))
    
    m = arr[0]
    cnt = 1
    for j in range(1,len(arr)):
        if arr[j] > m:
            m = arr[j]
            answer.append(cnt)
            cnt = 1
        else:
            cnt += 1
    answer.append(cnt)
    # return arr
    return answer