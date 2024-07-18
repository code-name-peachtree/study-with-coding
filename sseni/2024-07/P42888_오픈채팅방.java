package com.example.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class P42888_오픈채팅방 {
    public static String[] solution(String[] record) {
        HashMap<String, String> userMap = new HashMap<>();
        for (String r : record) {
            String[] arr = r.split(" ");
            if (!arr[0].equals("Leave")) {
                userMap.put(arr[1], arr[2]);
            }
        }

        ArrayList<String> answer = new ArrayList<>();
        for (String r : record) {
            String[] arr = r.split(" ");
            if (arr[0].equals("Enter")) {
                answer.add(userMap.get(arr[1]) + "님이 들어왔습니다.");
            } else if (arr[0].equals("Leave")) {
                answer.add(userMap.get(arr[1]) + "님이 나갔습니다.");
            }
        }

        return answer.toArray(String[]::new);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{
                "Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"})));
    }
}
