package com.example.algorithm;

public class P150365_미로탈출명령어 {
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};
    static String[] term = {"d", "l", "r", "u"}; // 사전 순으로
    static int mx, my;
    static int ex, ey;
    static String s = "";

    public static boolean dfs(int x, int y, int k, String str, int diff) {
        if (k == 0 && diff == 0) {
            s = str;
            return true;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || ny < 0 || nx >= mx || ny >= my && diff > k) continue;

            if ((diff % 2 == 0 && k % 2 == 0) || (diff % 2 == 1 && k % 2 == 1)) {
                if (dfs(nx, ny, k - 1, str + term[i], getDiff(nx, ny, ex, ey)))
                    return true;
            }
        }

        return false;
    }

    public static String solution(int n, int m, int x, int y, int r, int c, int k) {
        mx = n;
        my = m;
        ex = r - 1;
        ey = c - 1;

        int diff = getDiff(x - 1, y - 1, r - 1, c - 1);
        if (diff > k || (k - diff) % 2 != 0) return "impossible";

        dfs(x - 1, y - 1, k, "", diff);
        return s.equals("") ? "impossible" : s;
    }

    public static int getDiff(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    public static void main(String[] args) {
        System.out.println(solution(3, 4, 2, 3, 3, 1, 5));
        System.out.println(solution(2, 2, 1, 1, 2, 2, 2));
        System.out.println(solution(3, 3, 1, 2, 3, 3, 4));
    }
}
