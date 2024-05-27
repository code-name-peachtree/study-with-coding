package com.example.algorithm;

public class P250135_아날로그시계 {
    public static int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int start = toSecond(h1, m1, s1);
        int end = toSecond(h2, m2, s2);

        // (끝나는 시간까지 몇번 울리는지) - (시작 시간까지 몇번 울리는지) + (현재 시간에 울리는지)
        return cal(end) - cal(start) + (alramNow(start) ? 1 : 0);
    }

    static int cal(int time) {
        // 59 : 분심이 한 바퀴 돌 때, 초침과 60 - 1 = 59번 겹침
        int sm = time * 59 / 3600; // 울리는 횟수
        // 43200 : 시침이 한 바퀴 도는 데 43200초
        // 719 : 60(분) * 12(시간) - 1 번 겹친다.
        int sh = time * 719 / 43200;

        // 12:00:00 가 몇 번 나오는지 계산해서 빼줌
        // 12시 이상이면, 2번 나옴, 아니면 1번
        int a = 43200 <= time ? 2 : 1;
        return sm + sh - a;
    }

    // 시간을 초로 변환
    static int toSecond(int h, int m, int s) {
        int k = h * 3600 + m * 60 + s;
        return k;
    }

    // 현재 시간에 알림이 울리는지 체크
    static boolean alramNow(int time) {
        return time * 59 % 3600 == 0 || time * 719 % 43200 == 0;
    }

    public static void main(String[] args) {
        System.out.println(solution(0, 5, 30, 0, 7, 0));
        System.out.println(solution(12,0,0,12,0,30));
        System.out.println(solution(0,6,1,0,6,6));
    }
}
