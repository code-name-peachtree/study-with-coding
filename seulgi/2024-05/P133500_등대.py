import sys
from collections import defaultdict
sys.setrecursionlimit(1000001)

lst = defaultdict(list)
visited = [False] * 1000001

def dfs(u):
    visited[u] = True
    if not lst[u]:
        return 1,0
    
    on, off = 1, 0
    for v in [v for v in lst[u] if not visited[v]]:
        child_on, child_off = dfs(v)
        on += min(child_on, child_off)
        off += child_on
    return on, off

def solution(n, lighthouse):
    for u, v in lighthouse:
        lst[u].append(v)
        lst[v].append(u)
    on, off = dfs(1)
    return min(on, off)