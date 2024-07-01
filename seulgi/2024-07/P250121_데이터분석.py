def solution(data, ext, val_ext, sort_by):
    answer = []
    data_dict = {"code":0, "date":1, "maximum":2, "remain":3}
    for x in data:
        val = x[data_dict[ext]]
        if val <= val_ext:
            answer.append(x)
    answer.sort(key = lambda x : x[data_dict[sort_by]])
    return answer