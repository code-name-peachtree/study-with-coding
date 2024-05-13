import sys
sys.setrecursionlimit(10001)

m, n, k = map(int, sys.stdin.readline().split())

lst = [[0 for _ in range(n)] for _ in range(m)]

for _ in range(k):
    x1, y1, x2, y2 = map(int, sys.stdin.readline().split())
    for Y in range(y1, y2):
        for X in range(x1, x2):
            lst[Y][X] = 1

def dfs(x, y, cnt):
    lst[y][x] = 1
    for dx, dy in d:
        X, Y = x + dx, y + dy
        if(0 <= X < n) and (0 <= Y < m) and lst[Y][X] == 0:
            cnt = dfs(X, Y, cnt+1)

    return cnt

area = []
d = [(0, 1), (0, -1), (1, 0), (-1, 0)]

for Y in range(m):
    for X in range(n):
        if lst[Y][X] == 0:
            area.append(dfs(X, Y, cnt=1))

print(len(area))
print(*sorted(area))