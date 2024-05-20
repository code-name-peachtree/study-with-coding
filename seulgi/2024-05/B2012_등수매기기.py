n = int(input())
expect = []
for _ in range(n):
    expect.append(int(input()))

expect.sort()

result = 0
for i in range(1, n+1):
    result += abs(i-expect[i-1])
print(result)