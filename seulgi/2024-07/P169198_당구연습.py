def algorithm(x, y, startX, startY, ballX, ballY):
    dists = []

    if not (ballX == startX and ballY > startY):
        d2 = (ballX - startX)**2 + (ballY - 2*y+startY)**2
        dists.append(d2)

    if not (ballX == startX and ballY < startY):
        d2 = (ballX - startX)**2 + (ballY + startY)**2
        dists.append(d2)

    if not (ballY == startY and ballX < startX):
        d2 = (ballX + startX)**2 + (ballY - startY)**2
        dists.append(d2)

    if not (ballY == startY and ballX > startX):
        d2 = (ballX - 2*x+startX)**2 + (ballY - startY)**2
        dists.append(d2)
    
    return min(dists)
    
def solution(m, n, startX, startY, balls):
    answer = []
    for ballX, ballY in balls:
        answer.append(algorithm(m, n, startX, startY, ballX, ballY))
    return answer