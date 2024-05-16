def solution(elements):
    length = len(elements)
    res = set()
    
    for i in range(length):
        sum = elements[i]
        res.add(sum)
        for j in range(i+1, i+length):
            sum += elements[j%length]
            res.add(sum)
    return len(res)