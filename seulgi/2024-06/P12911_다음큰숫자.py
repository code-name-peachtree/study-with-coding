def cnt_one(n):
    binary = bin(n)
    cnt_one = binary.count('1')
    
    return cnt_one

def solution(n):
    answer = n
    num = cnt_one(n)
    while True:
        answer += 1
        if int(cnt_one(answer)) == num:
            return answer