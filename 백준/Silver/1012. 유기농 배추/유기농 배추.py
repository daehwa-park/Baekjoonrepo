import sys
sys.setrecursionlimit(100000)
def dfs(i, j):
    for d in range(4):
        nexti = i + di[d]
        nextj = j + dj[d]
        if nexti >= 0 and nexti < n and nextj >= 0 and nextj < m and array[nexti][nextj] == 1:
            array[nexti][nextj] = 2
            dfs(nexti, nextj)

di = [0, 1, 0, -1]
dj = [1, 0, -1, 0]

t = int(sys.stdin.readline())
for _ in range(t):
    m, n, k = map(int, sys.stdin.readline().split())

    cnt = 0

    array = [[0 for _ in range(m)] for _ in range(n)]

    for _ in range(k):
        x, y = map(int, sys.stdin.readline().split())
        array[y][x] = 1
    # end input

    for i in range(n):
        for j in range(m):
            if array[i][j] == 1:
                array[i][j] = 2
                dfs(i, j)
                cnt += 1

    print(cnt)

