package com.example.algorithm;

import java.util.*;

// 맞는 데이터 추출 -> 정렬
public class P250121_데이터분석 {
    public static int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int extIdx = findIdx(ext);
        int sortIdx = findIdx(sort_by);

        return Arrays.stream(data).filter(a -> a[extIdx] < val_ext)
                .sorted((a, b) -> a[sortIdx] - b[sortIdx]).toArray(int[][]::new);
    }

    static int findIdx(String str) {
        if(str.equals("code")) return 0;
        else if(str.equals("date")) return 1;
        else if(str.equals("maximum")) return 2;
        else return 3;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solution(
                new int[][]{{1, 20300104, 100, 80},
                        {2, 20300804, 847, 37},
                        {3, 20300401, 10, 8}},
                "date", 20300501, "remain")));
    }
}
