def solution(bandage, health, attacks):
    max_health = health
    time = 0
    conti_time = 0

    for i in range(len(attacks)):
        while True:
            time += 1
            conti_time += 1

            if attacks[i][0] == time:
                health -= attacks[i][1]
                conti_time = 0
                break
            else:
                if health != max_health:
                    if conti_time == bandage[0]:
                        health = health+ bandage[1] + bandage[2]
                        conti_time = 0
                    else:
                        health = health + bandage[1]
                if health > max_health:
                    health = max_health
        if health <= 0:
            return -1
    return health