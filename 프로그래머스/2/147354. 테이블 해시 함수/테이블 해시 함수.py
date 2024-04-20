def solution(data, col, row_begin, row_end):
    answer = 0
    data.sort(key = lambda x: (x[col-1],-x[0]))
    for i in range(row_begin-1,row_end):
        target = data[i]
        idx = i + 1
        val = 0
        for x in target:
            val += (x % idx)
        answer ^= val
    return answer