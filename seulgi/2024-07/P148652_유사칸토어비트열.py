def solution(n, l, r):
    answer = 0
    for l in range(l-1, r):
        if is_one(l):
            answer += 1
    return answer

def is_one(l):
    while l >= 5:
        if (l - 2) % 5 == 0:
            return False
        l //= 5

    return l != 2