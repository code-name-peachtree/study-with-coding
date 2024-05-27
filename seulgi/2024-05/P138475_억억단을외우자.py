def solution(e, starts):
    answer = [0 for i in range(e+1)]
    answer[1] = 1
    for i in range(2, e+1):
        for j in range(1, int(i**0.5)+1):
            if i % j == 0:
                answer[i] += 2
        if i**0.5 == int(i**0.5):
            answer[i] -= 1
    
    sort_answer = [i for i in range(e+1)]
    for i in reversed(range(1, e)):
        if answer[i] < answer[sort_answer[i+1]]:
            sort_answer[i] = sort_answer[i+1]
    return [sort_answer[s] for s in starts]