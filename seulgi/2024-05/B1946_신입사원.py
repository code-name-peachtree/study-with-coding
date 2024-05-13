import sys
input = sys.stdin.readline

T = int(input())

for _ in range(T):
    N = int(input())
    rank = sorted([list(map(int, input().split())) for _ in range(N)])
    top = 0
    answer = 1
    
    for i in range(1, len(rank)):
        if rank[i][1] < rank[top][1]:
            top = i
            answer += 1
    
    print(answer)