vowel = ['a', 'e', 'i', 'o', 'u']

l, c = map(int, input().split())

alpha = input().split()

alpha.sort()

def check(arr):
    v_cnt, c_cnt = 0, 0

    for i in arr:
        if i in vowel:
            v_cnt += 1
        else:
            c_cnt += 1

    if v_cnt >= 1 and c_cnt >= 2:
        return True
    else:
        return False

def backtracking(arr):

    if len(arr) == l:
        if check(arr):
            print("".join(arr))
            return

    for i in range(len(arr), c):
        if arr[-1] < alpha[i]:
            arr.append(alpha[i])
            backtracking(arr)
            arr.pop()

for i in range(c - l + 1):
    a = [alpha[i]]
    backtracking(a)