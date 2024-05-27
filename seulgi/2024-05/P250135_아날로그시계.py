def solution(h1, m1, s1, h2, m2, s2):
    answer = 0
    
    startT = h1 * 3600 + m1 * 60 + s1
    endT = h2 * 3600 + m2 * 60 + s2
    
    if startT == 0 * 3600 or startT == 12 * 3600:
        answer += 1
    
    while startT < endT:
        hAngle1 = startT / 120 % 360
        mAngle1 = startT / 10 % 360
        sAngle1 = startT * 6 % 360
        
        hAngle2 = 360 if (startT + 1) / 120 % 360 == 0 else (startT + 1) / 120 % 360
        mAngle2 = 360 if (startT + 1) / 10 % 360 == 0 else (startT + 1) / 10 % 360
        sAngle2 = 360 if (startT + 1) * 6 % 360 == 0 else (startT + 1) * 6 % 360
        
        if sAngle1 < hAngle1 and sAngle2 >= hAngle2:
            answer += 1
        if sAngle1 < mAngle1 and sAngle2 >= mAngle2:
            answer += 1
        if sAngle2 == hAngle2 and hAngle2 == mAngle2:
            answer -= 1

        startT += 1
    
    return answer