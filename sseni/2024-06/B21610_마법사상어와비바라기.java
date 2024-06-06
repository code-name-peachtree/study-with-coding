package com.example.algorithm.study;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B21610_마법사상어와비바라기 {
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int n, arr[][];
    static boolean[][] visited;
    static Queue<Point> points = new LinkedList<>();  // 구름

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 처음 구름은 (N-1, 0), (N-2, 1), (N-2, 0), (N-2, 1) 4칸에 존재
        points.add(new Point(n - 1, 0));
        points.add(new Point(n - 1, 1));
        points.add(new Point(n - 2, 0));
        points.add(new Point(n - 2, 1));

        visited = new boolean[n][n];
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());

            // TODO 1, 2 단계
            for (Point p : points) {
                // 구름이 di 방향으로 si칸 이동
                p.x = (n + p.x + dx[d] * (s % n)) % n;
                p.y = (n + p.y + dy[d] * (s % n)) % n;

                // 각 구름에서 비가 내려 구름이 있는 칸의 바구니에 저장된 물의 양이 1 증가
                arr[p.x][p.y]++;
            }

            // TODO 3, 4 단계
            while (!points.isEmpty()) {
                Point p = points.poll();
                visited[p.x][p.y] = true; // 구름 사라짐

                // 물복사버그 마법
                int cnt = 0;
                for (int k = 1; k <= 7; k += 2) { // 인접한 대각선 칸 검사
                    int nx = p.x + dx[k];
                    int ny = p.y + dy[k];

                    // 경계를 넘어가는 칸은 대각선 방향으로 거리가 1인 칸이 아니다.
                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                    if (arr[nx][ny] > 0) cnt++;
                }

                // 대각선 방향으로 거리가 1인 칸에 물이 있는 바구니의 수만큼 바구니의 물이 양이 증가
                arr[p.x][p.y] += cnt;
            }

            // TODO 5 단계
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // 3에서 구름이 사라진 칸이 아니며 물의 양이 2 이상인 칸 구름 생성
                    if (!visited[i][j] && arr[i][j] >= 2) {
                        points.add(new Point(i, j));
                        arr[i][j] -= 2; // 물의 양이 2 감소
                    }
                }
            }
            visited = new boolean[n][n]; // 구름 사라진 칸 초기화
        }

        int answer = 0;
        for (int[] num : arr) {
            for (int value : num) {
                answer += value;
            }
        }

        System.out.println(answer);
    }

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
