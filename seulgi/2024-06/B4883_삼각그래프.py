import sys
input = sys.stdin.readline

k= 1
while True:
    n = 0
    if not n:
        break
    dp=[]
    for i in range(n):
        dp.append(list(map(int,input().split())))
    ans = 0

    dp[1][0] += dp[0][1]
    dp[1][1] += min(dp[0][1], dp[0][1] + dp[0][2], dp[1][0])
    dp[1][2] += min(dp[0][1], dp[0][1] + dp[0][2], dp[1][1])

    for i in range(2,n):
        dp[i][0] += min(dp[i-1][0], dp[i-1][1])
        dp[i][1] += min(dp[i-1][0], dp[i-1][1], dp[i-1][2], dp[i][0])
        dp[i][2] += min(dp[i-1][1], dp[i-1][2], dp[i][1])

    print("%d. %d" %(k, dp[n-1][1]))
	
    k+=1