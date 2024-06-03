def solution(friends, gifts):
    friend_dict = dict()
    for i in range(len(friends)):
        friend_dict[friends[i]] = i
    table = [[0] * len(friends) for _ in range(len(friends))]
    
    gift_indices = [0] * len(friends)
    
    for i in gifts:
        giver, receiver = i.split()
        idx1, idx2 = friend_dict[giver], friend_dict[receiver]
        gift_indices[idx1] += 1
        gift_indices[idx2] -= 1
        table[idx1][idx2] += 1
    
    get_gift = [0] * len(friends)
    for i in range(len(friends)):
        for j in range(len(friends)):
            if i == j:
                continue
            if table[i][j] > table[j][i]:
                get_gift[i] += 1
            elif table[i][j] == table[j][i]:
                if gift_indices[i] > gift_indices[j]:
                    get_gift[i] += 1
    return max(get_gift)