import sys
input = sys.stdin.readline

n, m, l = map(int, input().split())
location = [0]+list(map(int, input().split()))+[l]
location.sort()

start, end = 1, l-1
ans = 0
while start <= end:
    cnt = 0
    mid = (start+end) // 2
    for i in range(1, len(location)):
        if location[i]-location[i-1] > mid:
            cnt += (location[i]-location[i-1]-1)//mid
    if cnt > m: #설치해야 할 휴게소 개수가 m보다크다면 mid는 더 길어야함
        start = mid+1
    else: #설치해야 할 휴게소 개수가 m보다 작다면 mid는 더 짧아야함(조건 만족)
        end = mid-1
        ans = mid
print(ans)