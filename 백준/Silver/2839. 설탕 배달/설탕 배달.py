# X = 5k + 3l
def find_min_lk(x):
    for n in range(x // 5 + 1):
        for l in range(5):
            k = (x - 3 * l) // 5
            if k >= 0 and (3 * l + 5 * k) == x:
                return l, k
    return -1

# 사용자로부터 입력 받기
user_input = int(input())

# 최소의 L, K 찾기
result = find_min_lk(user_input)

# 결과 출력
if result != -1:
    l, k = result
    # print(f"X를 표현하는 최소의 L, K 값은 L={l}, K={k}입니다.")
    print(l+k)
else:
    print(-1)
