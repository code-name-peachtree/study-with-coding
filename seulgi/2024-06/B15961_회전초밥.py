N, d, k, c = map(int, input().split())
plate = [int(input()) for _ in range(N)]
answer = 0

for i in range(N):
    if i <= N-k:
        tmp = set(plate[i:i+k])
    else:
        tmp = set(plate[i:])
        tmp.update(plate[:(i+k)%N])
    tmp.add(c)
    answer = max(answer, len(tmp))

print(answer)