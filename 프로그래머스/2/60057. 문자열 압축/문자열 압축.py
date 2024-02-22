def solution(s):
    min_len = float('inf')
    
    if len(s) == 1:
        return 1
    
    for i in range(len(s) // 2):
        tmp_min = 0
        cnt = 0
        idx = 0
        before = s[0:i+1]
        while idx + i < len(s):
            sub = s[idx:idx+i+1]
            if before == sub:
                cnt += 1
            else:
                if cnt > 1:
                    time = 0
                    num = cnt
                    while num:
                        num //= 10
                        time += 1
                    tmp_min += len(before) + time
                else:
                    tmp_min += len(before)
                before = sub
                cnt = 1
            idx = idx + i + 1
            if idx + i >= len(s):
                tmp_min += len(s) - idx
                if cnt > 1:
                    time = 0
                    num = cnt
                    while num:
                        num //= 10
                        time += 1
                    tmp_min += len(before) + time
                else:
                    tmp_min += len(before)
                break
        min_len = min(min_len, tmp_min)
        
    return min_len