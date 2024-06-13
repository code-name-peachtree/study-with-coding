n = int(input())
table = [list(map(int, input().split())) for _ in range(6)]

w = 0
w_idx = 0
h = 0
h_idx = 0

for i in range(len(table)):
    if table[i][0] == 1 or table[i][0] == 2:
        if w < table[i][1]:
            w = table[i][1]
            w_idx = i
    elif table[i][0] == 3 or table[i][0] == 4:
        if h < table[i][1]:
            h = table[i][1]
            h_idx = i

w2 = abs(table[(w_idx-1) % 6][1] - table[(w_idx+1) % 6][1])
h2 = abs(table[(h_idx-1) % 6][1] - table[(h_idx+1) % 6][1])

result = ((w*h)-(w2*h2)) * n
print(result)