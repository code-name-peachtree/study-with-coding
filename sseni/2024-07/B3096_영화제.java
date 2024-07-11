package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.BitSet;
import java.util.StringTokenizer;

public class B3096_영화제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long answer = 0;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        BitSet[] bs = new BitSet[n + 1]; // 왼쪽 마을 기준 연결된 오른쪽 마을
        for (int i = 1; i <= n; i++) {
            bs[i] = new BitSet();
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bs[a].set(b);
        }

        // i, j로 왼쪽에서 두개 골라놓고, 오른쪽 마을에서 고를 수 있는 쌍을 계산, answer 에 저장
        for (int i = 1; i <= n; i++) { // 두 왼쪽 마을 i, j 선택
            for (int j = i + 1; j <= n; j++) {
                BitSet set = new BitSet(); // 오른쪽 마을 쌍 계산 위한 BitSet
                set.or(bs[i]);
                set.and(bs[j]);
                answer += ((long) set.cardinality() * (set.cardinality() - 1)) / 2; // 오른쪽 마을 조합 계산 nC2
            }
        }

        System.out.println(answer);
    }
}
