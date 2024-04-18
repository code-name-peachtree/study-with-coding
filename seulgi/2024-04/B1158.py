from collections import deque

n, k = map(int, input().split())

ppl = deque()
for i in range(1, n+1): ppl.append(i)
result = []

while ppl:
  for _ in range(k-1):
    ppl.append(ppl.popleft())

  result.append(ppl.popleft())

print(str(result).replace('[', '<').replace(']', '>'))