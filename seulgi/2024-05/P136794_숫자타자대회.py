costs =     [[1, 7, 6, 7, 5, 4, 5, 3, 2, 3]
            ,[7, 1, 2, 4, 2, 3, 5, 4, 5, 6]
            ,[6, 2, 1, 2, 3, 2, 3, 5, 4, 5]
            ,[7, 4, 2, 1, 5, 3, 2, 6, 5, 4]
            ,[5, 2, 3, 5, 1, 2, 4, 2, 3, 5]
            ,[4, 3, 2, 3, 2, 1, 2, 3, 2, 3]
            ,[5, 5, 3, 2, 4, 2, 1, 5, 3, 2]
            ,[3, 4, 5, 6, 2, 3, 5, 1, 2, 4]
            ,[2, 5, 4, 5, 3, 2, 3, 2, 1, 2]
            ,[3, 6, 5, 4, 5, 3, 2, 4, 2, 1]]

def solution(numbers):
    now = 0
    left = 4
    right = 6
    all_dict = {}
    finger_pos = (left, right)
    all_dict[finger_pos] = now
    
    for str_num in numbers:
        num = int(str_num)
        curr_dict = {}
        for finger_pos, weight in all_dict.items():
            left, right = finger_pos
            if right == num:
                if not (left, num) in curr_dict.keys() or curr_dict[(left, num)] > weight + 1:
                    curr_dict[(left, num)] = weight + 1
            elif left == num:
                if not (num, right) in curr_dict.keys() or curr_dict[(num, right)] > weight + 1:
                    curr_dict[(num, right)] = weight + 1
            else:
                if not (left, num) in curr_dict.keys() or curr_dict[(left, num)] > weight + costs[right][num]:
                    curr_dict[(left, num)] = weight + costs[right][num]
                if not (num, right) in curr_dict.keys() or curr_dict[(num, right)] > weight + costs[left][num]:
                    curr_dict[(num, right)] = weight + costs[left][num]
        all_dict = curr_dict

    return min(list(all_dict.values()))