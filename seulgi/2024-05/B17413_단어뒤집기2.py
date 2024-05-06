s = input()

stack = []
result = ''
flag = False

for i in s:
    if i == '<':
        flag = True
        for _ in range(len(stack)):
            result += stack.pop()
    stack.append(i)
    if i == '>':
        flag = False
        for _ in range(len(stack)):
            result += stack.pop(0)
    if i == ' ' and flag == False:
        for j in range(len(stack)):
            if j == 0:
                stack.pop()
                continue
            result += stack.pop()
        result += ' '

if stack:
    for _ in range(len(stack)):
        result += stack.pop()

print(result)