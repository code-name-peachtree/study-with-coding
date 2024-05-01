package com.example.algorithm.study;

public class P12909_올바른괄호 {
    static boolean solution(String s) {
        int cnt = 0;

        for (Character c : s.toCharArray()) {
            if(c == '(') cnt++;
            else if(cnt > 0) cnt--;
            else return false;
        }

        return cnt == 0;
    }

    public static void main(String[] args) {
        System.out.println(solution("()()"));
        System.out.println(solution("(())()"));
        System.out.println(solution(")()("));
        System.out.println(solution("(()("));
    }
}
