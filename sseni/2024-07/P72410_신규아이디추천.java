package com.example.algorithm;

public class P72410_신규아이디추천 {
    public static String solution(String new_id) {
        // 1
        String answer = new_id.toLowerCase();
        // 2
        answer = answer.replaceAll("[^-_.a-z0-9]", "");
        // 3
        answer = answer.replaceAll("\\.+", ".");
        // 4
        answer = answer.replaceAll("^[.]|[.]$", "");
        // 5
        if (answer.equals(""))
            answer = "a";
        // 6
        if (answer.length() > 15){
            answer = answer.substring(0, 15);
            answer = answer.replaceAll("[.]$", "");
        }
        // 7
        while (answer.length() < 3)
            answer += answer.charAt(answer.length() - 1);

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("...!@BaT#*..y.abcdefghijklm"));
    }
}
