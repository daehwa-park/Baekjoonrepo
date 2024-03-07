from collections import deque

def solution(numbers):
    answer = [-1] * len(numbers)
    s = deque()
    
    for i in range(len(numbers)):
        while s and numbers[s[-1]] < numbers[i]:
            answer[s.pop()] = numbers[i]   
        s.append(i)
    
    return answer