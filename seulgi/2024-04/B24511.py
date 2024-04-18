import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
a = list(map(int, input().split()))
b = list(map(int, input().split()))
m = int(input())
c = list(map(int, input().split()))
queue = deque()
for i in range(n):
    if a[i] == 0:
        queue.append(b[i])
for i in c:
    queue.appendleft(i)
    print(queue.pop(), end=" ")