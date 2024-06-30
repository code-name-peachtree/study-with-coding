from collections import Counter
def solution(k, tangerine):
    answer = 0
    tan_dict = Counter(tangerine)
    tan_dict = sorted(tan_dict.items(), key = lambda x : x[1], reverse = True)
    
    for x in tan_dict:
        k -= x[1]
        answer += 1
        if(k <= 0):
            break
    return answer