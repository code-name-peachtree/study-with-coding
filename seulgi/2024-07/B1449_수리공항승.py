import sys
input = sys.stdin.readline

n, l = map(int, input().split())
pipe = list(map(int, input().split()))

pipe.sort()

start = pipe[0]

cnt = 1

for i in pipe[1:]:
    if i in range(start, start+l):
        continue
    else:
        start = i
        cnt += 1

print(cnt)