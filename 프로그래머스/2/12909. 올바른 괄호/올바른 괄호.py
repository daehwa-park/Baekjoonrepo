from collections import deque

def solution(s):
    answer = True
    
    stack = deque()
    
    for brace in s:
        stack.append(brace)
        
    count = 0
    while stack:
        cur = stack.pop()
        if cur == ')':
            count += 1
        elif cur == '(' and count >= 1:
            count -= 1
        else:
            return False
    
    if count > 0:
        return False

    return True