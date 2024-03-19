from itertools import combinations

def perm(dice, dlist, cnt, sum, arr): # 중복 순열
    if cnt == len(dice) // 2:
        arr.append(sum)
        return
    for i in range(6):
        perm(dice, dlist, cnt + 1, sum + dice[dlist[cnt]][i], arr)
    
def solution(dice):
    answer = []
    m = -1 # 최대 승리 수 
    
    ll = len(dice) 
    
    dice_list = [i for i in range(ll)] # 주사위 번호
    comb = combinations(dice_list, ll // 2) # 조합 구하기 
    
    for c in comb:
        arrA = [] # A가 고른 주사위의 합 리스트
        arrB = [] # B가 고른 주사위의 합 리스트
        adice = list(c) # A가 고른 주사위
        bdice = [] # B가 고른 주사위
        for i in range(ll): 
            if i not in adice:
                bdice.append(i)
        perm(dice, adice, 0, 0, arrA) # A가 고른 주사위에서 나올 수 있는 합 경우 구하기 6^5
        perm(dice, bdice, 0, 0, arrB) # B가 고른 주사위에서 나올 수 있는 합 경우 구하기 6^5
        # 나눠서 하는 이유는 주사위 10개를 한번에 구하면 6^10가지라서 시간초과
        arrA.sort() 
        arrB.sort()
        i = 0 # A의 인덱스
        sum = 0 # 승리한 경우의 합
        s = 0 # B의 인덱스
        while i != len(arrA): # A의 합보다 작은 경우를 구하기, 정렬되어 있어서 앞에서부터 자신보다 큰 수가 나올 때의 인덱스가 승리한 경우의 수, A의 합이 무조건 커지기 때문에 승리한 경우의 수도 줄어들지 않고 늘어난다
            while s != len(arrB) and arrA[i] > arrB[s]:
                s += 1
            sum += s
            i += 1
        if m < sum:
            m = sum
            answer = [i + 1 for i in adice]
    
    return answer