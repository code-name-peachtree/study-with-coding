package com.example.algorithm.study;

import java.util.*;

public class P176962_과제진행하기 {
    public static String[] solution(String[][] plans) {
        LinkedList<Task> tasks = new LinkedList<>();
        for (int i = 0; i < plans.length; i++) {
            tasks.add(new Task(plans[i][0], plans[i][1], plans[i][2]));
        }

        tasks.sort((a, b) -> a.start - b.start);

        Stack<Task> stack = new Stack<>();
        List<String> list = new ArrayList<>();

        Task now = tasks.poll();
        int time = now.start;

        while (!tasks.isEmpty()) {
            time += now.time;
            Task next = tasks.peek();

            if (time > next.start) {
                now.time = time - next.start;
                stack.push(now);
            } else {
                list.add(now.str);
                if (!stack.isEmpty()) {
                    now = stack.pop();
                    continue;
                }
            }

            now = tasks.poll();
            time = now.start;
        }

        list.add(now.str);
        while (!stack.isEmpty()) {
            list.add(stack.pop().str);
        }

        return list.toArray(new String[0]);
    }

    static class  Task {
        String str;
        int start;
        int time;

        Task(String str, String start, String time) {
            this.str = str;
            String[] strArr = start.split(":");
            this.start = Integer.parseInt(strArr[0]) * 60 + Integer.parseInt(strArr[1]);
            this.time = Integer.parseInt(time);
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                solution(new String[][]{
                        {"korean", "11:40", "30"},
                        {"english", "12:10", "20"},
                        {"math", "12:30", "40"}})));
    }
}
