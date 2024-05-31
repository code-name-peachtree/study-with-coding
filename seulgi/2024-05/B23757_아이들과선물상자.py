import heapq as hq

n, m = map(int, input().split())
present = []
for x in list(map(int, input().split())):
    hq.heappush(present, -x)

wish = list(map(int, input().split()))

empty = False

for i in wish:
    x = -hq.heappop(present)
    if x - i < 0:
        empty = True
        break
    hq.heappush(present, -(x-i))

if empty:
    print(0)
else:
    print(1)