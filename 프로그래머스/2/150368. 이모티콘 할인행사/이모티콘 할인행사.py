sale = [10, 20, 30, 40]
result = [0] * 7
max_plus = 0
max_price = 0

def solution(users, emoticons):
    answer = []
    
    #result = [0 for _ in range(len(emoticons))]
    
    go(0, len(emoticons), users, emoticons)
    
    return [max_plus, max_price]

def go(cnt, dst, users, emoticons):
    global max_plus, max_price
    if cnt == dst:
        # 계산
        all_price = 0
        all_plus = 0
        for i,j in users:
            price = 0
            for d in range(len(emoticons)):
                if i <= result[d]:
                    price += emoticons[d] * (100 - result[d]) / 100
            if price >= j:
                all_plus += 1
            else:
                all_price += price
        if max_plus < all_plus:
            max_plus = all_plus
            max_price = all_price
        elif max_plus == all_plus and max_price <= all_price:
            max_price = all_price
        return
    
    for i in sale:
        result[cnt] = i
        go(cnt + 1, dst, users, emoticons)