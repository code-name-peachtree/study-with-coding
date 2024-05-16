def solution(n, times):
    minimum = 1
    maximum = max(times) * n
    
    while minimum <= maximum:
        mid = (minimum+maximum)//2
        ppl = 0
        
        for t in times:
            ppl += mid//t
            
            if ppl >= n:
                break
        if ppl >= n:
            answer = mid
            maximum = mid - 1
        else:
            minimum = mid + 1
    return answer