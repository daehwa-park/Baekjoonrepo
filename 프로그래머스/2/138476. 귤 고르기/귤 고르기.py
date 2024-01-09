def solution(k, tangerine):
    answer = 0
    
    h = [0 for _ in range(10000001)]
    
    for t in tangerine:
        h[t] += 1
        
    h.sort(reverse=True)
    
    sum = 0
    for i, p in enumerate(h):
        sum += p
        if sum >= k:
            answer = i + 1
            break
    
    return answer