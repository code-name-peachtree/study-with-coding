package com.example.algorithm.study;

public class P214289_에어컨 {
    public static int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        int[][] dp = new int[51][onboard.length + 1];
        temperature += 10;  // 온도 범위를 양수 범위로
        t1 += 10;
        t2 += 10;

        for (int i = onboard.length - 1; i >= 0; i--) {
            for (int t = 0; t < 51; t++) {
                dp[t][i] = Integer.MAX_VALUE - Math.max(a, b);

                if (onboard[i] == 1 && (t < t1 || t > t2)) continue; // 현재 시간에 승객이 탑승했고, 탑승 가능 온도 범위를 벗어났으면 continue

                if (t == temperature) { // 현재 온도가 희망 온도랑 같으면,
                    dp[t][i] = Math.min(dp[t][i], dp[t][i + 1]);
                } else if (t > 0 && t > temperature) { // 현재 온도가 희망 온도보다 높으면,
                    dp[t][i] = Math.min(dp[t][i], dp[t - 1][i + 1]);
                } else if (t < 50 && t < temperature) { // 현재 온도가 희망 온도보다 낮으면,
                    dp[t][i] = Math.min(dp[t][i], dp[t + 1][i + 1]);
                }

                // 필요한 에너지 추가 (에어컨을 작동시킬 수 있는 경우)
                if (t < 50) {
                    dp[t][i] = Math.min(dp[t][i], dp[t + 1][i + 1] + a);
                }
                if (t > 0) {
                    dp[t][i] = Math.min(dp[t][i], dp[t - 1][i + 1] + a);
                }

                // 필요한 에너지 추가 (에어컨을 작동하지 않는 경우)
                dp[t][i] = Math.min(dp[t][i], dp[t][i + 1] + b);
            }
        }

        return dp[temperature][0];
    }

    public static void main(String[] args) {
        System.out.println(solution(28, 18, 26, 10, 8,
                new int[]{0, 0, 1, 1, 1, 1, 1}));
//        System.out.println(solution(-10, -5, 5, 5, 1,
//                new int[]{0, 0, 0, 0, 0, 1, 0}));
//        System.out.println(solution(11, 8, 10, 10, 1,
//                new int[]{0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1}));
    }
}
