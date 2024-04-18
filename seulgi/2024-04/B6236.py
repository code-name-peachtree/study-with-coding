import sys
n,m=map(int, sys.stdin.readline().split())

money=[]
for _ in range(n):
    money.append(int(sys.stdin.readline()))

start=max(money) #n일동안 써야 하므로 적어도 돈의 최대값은 되야한다.
end=sum(money) #한번에 뽑아서 다 쓰는 경우가 가장 최대일 때.

answer=0
while start<=end:
    mid=(start+end)//2

    total=0
    cnt=0
    for x in money:
        if total+x<=mid:
            total+=x
        else:
            cnt+=1
            total=0
            total+=x
    if total: #마지막 돈에 대해서 total에 금액이 있으면 cnt++ 처리.
        cnt+=1

    if cnt>m: #횟수가 많으면 인출 금액을 늘려야 됨.
        start=mid+1
    else: #횟수가 적거나 같으면 인출 금액을 줄여야 됨.
        end=mid-1
        answer=mid

print(answer)