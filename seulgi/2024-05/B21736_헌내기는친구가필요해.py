import sys
from collections import deque

N, M = map(int, sys.stdin.readline().strip().split())

dr = [-1, 0, 1, 0]
dc = [0, 1, 0, -1]
ch = [[0] * M for _ in range(N)]

campus = []
Q = deque()

for i in range(N):
  campus.append(list(map(str, sys.stdin.readline().strip())))

  for j in range(len(campus[i])):
    if campus[i][j] == 'I':
      Q.append([i, j])
      ch[i][j] = 1

answer = 0

while Q:
  for _ in range(len(Q)):
    r, c = Q.popleft()
    
    for i in range(4):
      nr, nc = r + dr[i], c + dc[i]

      if 0 <= nr < N and 0 <= nc < M and ch[nr][nc] == 0 and campus[nr][nc] != 'X':
        if campus[nr][nc] == 'P':
          answer += 1

        ch[nr][nc] = 1
        Q.append([nr, nc])

if answer:
  print(answer)
else:
  print('TT')