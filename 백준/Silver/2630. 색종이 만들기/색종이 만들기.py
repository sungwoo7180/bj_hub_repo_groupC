def count_papers(paper, x, y, size):
    # 크기가 1이면 return
    if size == 1:
        if paper[x][y] == 0:
            return (1, 0)
            #파이썬에서는 반환할 값들을 쉼표로 구분하기만 하면 자동으로 튜플로 묶어 처리합니다
        else:
            return (0, 1)

    # 해당 영역이 모두 같은 색인지 체크
    first_color = paper[x][y]
    all_same_color = True
    for i in range(x, x + size):
        if not all_same_color:
            break
        for j in range(y, y + size):
            if paper[i][j] != first_color:
                all_same_color = False
                break

    # 영역의 모든 칸이 같은 색이면 해당 색상의 카운트를 반환
    if all_same_color:
        if first_color == 0:
            return (1, 0)
        else:
            return (0, 1)

    # 영역이 같은 색이 아니면 4분할, 재귀
    mid = size // 2
    top_left = count_papers(paper, x, y, mid)
    top_right = count_papers(paper, x, y + mid, mid)
    bottom_left = count_papers(paper, x + mid, y, mid)
    bottom_right = count_papers(paper, x + mid, y + mid, mid)

    # count
    white_count = top_left[0] + top_right[0] + bottom_left[0] + bottom_right[0]
    blue_count = top_left[1] + top_right[1] + bottom_left[1] + bottom_right[1]
    return (white_count, blue_count)

# 입력받기
N = int(input())
paper = []

# 2차원 리스트
for _ in range(N):
    row = list(map(int, input().split()))   # 띄어쓰기를 기준으로 배열로 만들어주는 문법
    paper.append(row)

# 재귀 함수를 호출하여 하얀색과 파란색 종이의 개수를 센다.
white_papers, blue_papers = count_papers(paper, 0, 0, N)

# 결과 출력
print(paper)
print(white_papers)
print(blue_papers)
