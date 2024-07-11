from itertools import combinations

def count_festival_combinations(N, M, connections):
    # 왼쪽 마을과 연결된 오른쪽 마을 정보를 저장하는 딕셔너리
    left_to_right = {i: set() for i in range(1, N+1)}
    
    for l, r in connections:
        left_to_right[l].add(r)
    
    # 가능한 조합의 수를 저장하는 변수
    count = 0
    
    # 왼쪽 마을 중 2개를 선택하는 조합을 생성
    left_combinations = list(combinations(range(1, N+1), 2))
    
    for left1, left2 in left_combinations:
        # 두 왼쪽 마을에 모두 연결된 오른쪽 마을을 찾아야 함
        right_candidates = left_to_right[left1] & left_to_right[left2]
        
        # 오른쪽 마을 중 2개를 선택하는 조합의 수를 계산
        if len(right_candidates) >= 2:
            right_combinations = list(combinations(right_candidates, 2))
            count += len(right_combinations)
    
    return count

# 입력 받기
N, M = map(int, input().split())
connections = [tuple(map(int, input().split())) for _ in range(M)]

# 결과 출력
print(count_festival_combinations(N, M, connections))