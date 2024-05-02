def solution(temperature, t1, t2, a, b, onboard):
    answer = 0
    if t1 < t2:
        temperature, t1, t2 = -temperature, -t2, -t1
    n = len(onboard)
    dp = [[1e9]*100 for i in range(n)]; dp[0][temperature]=0
    for i in range(1, n):
        for j in range(t1, temperature+1):
            if onboard[i] and not t1<=j<=t2:
                continue
            dp[i][j] = min(dp[i-1][j-1], dp[i-1][j+1]+a, dp[i-1][j]+b)
            if not onboard[j]:
                dp[i][temperature] = min(dp[i][temperature], dp[i-1][temperature])
    answer = min(dp[-1])