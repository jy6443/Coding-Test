
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    p, q, r, s, w = map(int,input().split())
    a = p * w
    b = q + max(0,w-r) * s
    print("#"+str(test_case),min(a,b))
