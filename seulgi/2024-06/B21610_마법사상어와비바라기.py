N, M = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]
moves = [tuple(map(int, input().split())) for _ in range(M)]

dy8 = ("empty", 0, -1, -1, -1, 0, 1, 1, 1)
dx8 = ("empty", -1, -1, 0, 1, 1, 1, 0, -1)
dy4 = (-1, -1,  1, 1)
dx4 = (-1,  1, -1, 1)

clouds = [(N-1, 0), (N-1, 1), (N-2, 0), (N-2, 1)]
for d, s in moves:
    moved_clouds = []
    for y, x in clouds:
        ny = (y + dy8[d] * s) % N 
        nx = (x + dx8[d] * s) % N
        board[ny][nx] += 1
        moved_clouds.append((ny, nx))

    for y, x in moved_clouds:
        cnt = 0
        for d in range(4):
            ny = y + dy4[d]
            nx = x + dx4[d]
            if ny < 0 or nx < 0 or ny >= N or nx >= N: continue
            elif board[ny][nx] > 0: cnt += 1
        board[y][x] += cnt

    new_clouds = []
    for y in range(N):
        for x in range(N):
            if (y, x) in moved_clouds or board[y][x] < 2:
                continue
            board[y][x] -= 2
            new_clouds.append((y, x))
    clouds = new_clouds

result = 0
for y in range(N):
    for x in range(N):
        result += board[y][x]
print(result)