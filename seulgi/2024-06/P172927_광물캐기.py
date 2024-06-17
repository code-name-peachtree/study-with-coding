def solution(picks, minerals):
    answer = 0
    
    minerals = minerals[:sum(picks)*5]
    minerals = [minerals[i:i+5] for i in range(0, len(minerals), 5)]
    
    costs = []
    for mineral in minerals:
        cost = [0, 0, 0] # dia, iron, ston
        for mine in mineral:
            if mine == 'diamond':
                cost[0] += 1
                cost[1] += 5
                cost[2] += 25
            elif mine == 'iron':
                cost[0] += 1
                cost[1] += 1
                cost[2] += 5
            else:
                cost[0] += 1
                cost[1] += 1
                cost[2] += 1
        costs.append(cost)
    
    costs = sorted(costs, key=lambda x: (-x[0], -x[1], -x[2]))
    
    for cost in costs:
        if picks[0] > 0:
            picks[0] -= 1
            answer += cost[0]
            continue
        elif picks[1] > 0:
            picks[1] -= 1
            answer += cost[1]
            continue
        elif picks[2] > 0:
            picks[2] -= 1
            answer += cost[2]
            continue
    
    return answer