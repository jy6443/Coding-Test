from heapq import heappush, heappop
def solution(m, musicinfos):
    answer = '(None)'
    info = []
    h = []
    m = m.replace('C#','c').replace('D#','d').replace('F#','f').replace('G#','g').replace('A#','a').replace('B#','b')
    for i in range(0,len(musicinfos)):
        start,end,title,mel = musicinfos[i].split(',')
        if 'C#' in mel or 'D#' in mel or 'F#' in mel or 'G#' in mel or 'A#' in mel:
            mel = mel.replace('C#','c').replace('D#','d').replace('F#','f').replace('G#','g').replace('A#','a').replace('B#','b')
        hs, ms = start.split(':')
        he, me = end.split(':')
        time = (int(he)*60 + int(me)) - (int(hs)*60 + int(ms))
        info.append((time,title,mel))
    
        ite = time // len(mel)
        arr = mel
        for j in range(ite):
            arr += mel
        mel = arr[:time]
        if m in mel:
            answer = title
            heappush(h,[-time,i,title])
    
    if h:
        answer = heappop(h)[2]
    return answer