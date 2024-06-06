def solution(n, m, x, y, r, c, k):
    counts = {'d': 0, 'l': 0, 'r': 0, 'u': 0}
    extra = ''
    
    x_diff, y_diff = r - x, c - y
    x_direction = 'u' if x_diff < 0 else 'd'
    y_direction = 'l' if y_diff < 0 else 'r'
    
    x_wall, y_wall = min(n - x, n - r), min(y, c) - 1 
    
    extra_moves = k - (abs(x_diff) + abs(y_diff))

    if extra_moves < 0 or extra_moves % 2 == 1:
        return 'impossible'
    
    counts[x_direction] += abs(x_diff)
    counts[y_direction] += abs(y_diff)

    if extra_moves > x_wall * 2:
        counts['d'] += x_wall
        counts['u'] += x_wall
        extra_moves -= x_wall * 2
    else:
        counts['d'] += extra_moves // 2
        counts['u'] += extra_moves // 2
        extra_moves = 0
    
    if extra_moves > y_wall * 2:
        counts['l'] += y_wall
        counts['r'] += y_wall
        extra_moves -= y_wall * 2
    else:
        counts['l'] += extra_moves // 2
        counts['r'] += extra_moves // 2
        extra_moves = 0

    if extra_moves > 0:
        extra = 'rl' * (extra_moves // 2)

    answer = counts['d'] * 'd' + counts['l'] * 'l' + extra + counts['r'] * 'r' + counts['u'] * 'u'
    return answer