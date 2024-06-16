n = int(input())
grade = [list(input().split()) for _ in range(n)]

grade.sort(key = lambda x: (-int(x[1]), int(x[2]), -int(x[3]), x[0]))

for name in grade:
    print(name[0])