def solution(record):
    answer = []
    id = {}
    
    for i in record:
        contents = i.split()
        
        if contents[0] in ['Enter', 'Change']:
            id[contents[1]] = contents[2]
    
    for i in record:
        contents = i.split()
        if contents[0] == 'Enter':
            answer.append(f'{id[contents[1]]}님이 들어왔습니다.')
        elif contents[0] == 'Leave':
            answer.append(f'{id[contents[1]]}님이 나갔습니다.')
    
    return answer