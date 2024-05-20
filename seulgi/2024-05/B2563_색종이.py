n = int(input())
ary = [[0]*100 for _ in range(100)]
for _ in range(n):
    y1, x1 = map(int, input().split())

    for i in range(x1, x1+10):
        for j in range(y1, y1+10):
            ary[i][j] = 1

result = 0
for k in range(100):
    result += ary[k].count(1)

print(result)