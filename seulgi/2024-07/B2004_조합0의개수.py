import sys
input = sys.stdin.readline

n, m = map(int, input().split())


def two_cnt(num):
    cnt = 0
    while num != 0:
        num = num // 2
        cnt += num
    return cnt

def five_cnt(num):
    cnt = 0
    while num != 0:
        num = num // 5
        cnt += num
    return cnt

print(min(two_cnt(n) - two_cnt(n - m) - two_cnt(m), five_cnt(n) - five_cnt(n - m) - five_cnt(m)))