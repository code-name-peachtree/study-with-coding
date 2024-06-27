import sys
input = sys.stdin.readline

m, n = map(int, input().split())
snack = list(map(int, input().split()))

start = 1
end = max(snack)
ans = 0

while(start <= end):
    total = 0
    mid = (start + end) // 2

    for i in snack:
        if i >= mid:
            total += i // mid
    
    if total >= m:
        ans = mid
        start = mid + 1
    else:
        end = mid -1

print(ans)