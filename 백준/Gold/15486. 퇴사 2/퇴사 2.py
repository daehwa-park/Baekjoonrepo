import sys

n = int(sys.stdin.readline())

arr = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
d = [0 for _ in range(n + 1)]

for i in range(n - 1, -1, -1):
    if i + arr[i][0] > n:
        d[i] = d[i + 1]
    else:
        d[i] = max(d[i + arr[i][0]] + arr[i][1], d[i + 1])

print(d[0])

