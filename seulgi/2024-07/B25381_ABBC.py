def max_deletions(s):
    stack = []
    deletions = 0

    for char in s:
        if stack:
            # Check for "AB" pattern
            if stack[-1] == 'A' and char == 'B':
                stack.pop()
                deletions += 1
                continue
            # Check for "BC" pattern
            elif stack[-1] == 'B' and char == 'C':
                stack.pop()
                deletions += 1
                continue
        
        stack.append(char)
    
    return deletions

# 입력 받기
s = input().strip()

# 결과 출력
print(max_deletions(s))