import sys

def sol(day):
    if day == n:
        return 0
    if day > n:
        return -1000000
    if d[day] != -1:
        return d[day]

    t1 = sol(day + arr[day][0]) + arr[day][1]
    t2 = sol(day + 1)

    d[day] = max(t1, t2)
    return d[day]

n = int(sys.stdin.readline())

arr = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
d = [-1 for _ in range(n)]

ans = sol(0)

print(ans)
