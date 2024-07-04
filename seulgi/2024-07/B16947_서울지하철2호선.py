import sys
from collections import deque
input = sys.stdin.readline
sys.setrecursionlimit(100000)

def circulation(start, idx, cnt):
    global cycle

    if start == idx and cnt >= 2:
        cycle = True
        return
    
    visited[idx] = True

    for i in info[idx]:
        if not visited[i]:
            circulation(start, i , cnt+1)
        elif i == start and cnt >= 2:
            circulation(start, i , cnt)

def distance():
    global check
    q = deque()
    for i in range(n):
        if cycle[i]:
            check[i] = 0
            q.append(i)
    while q:
        now = q.popleft()
        for i in info[now]:
            if check[i] == -1:
                q.append(i)
                check[i] = check[now] + 1
    for i in check:
        print(i, end=' ')

n = int(input())
info = [[] for _ in range(n)]
cycle = [False] * n
check = [-1] *n

for _ in range(n):
    a, b = map(int, input().split())
    info[a-1].append(b-1)
    info[b-1].append(a-1)

for i in range(n):
    visited = [False] * n
    cycle = False
    circulation(i, i, 0)

    if cycle:
        cycle = True

distance()