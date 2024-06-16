package com.example.algorithm.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B10825_국영수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            String[] strArray = br.readLine().split(" ");
            students[i] = new Student(strArray[0],
                    Integer.parseInt(strArray[1]),
                    Integer.parseInt(strArray[2]),
                    Integer.parseInt(strArray[3]));
        }

        Arrays.sort(students, (s1, s2) -> {
            if(s1.a != s2.a) return Integer.compare(s2.a, s1.a);
            else if(s1.b != s2.b) return Integer.compare(s1.b, s2.b);
            else if(s1.c != s2.c) return Integer.compare(s2.c, s1.c);
            else return s1.name.compareTo(s2.name);
        });

        StringBuilder sb = new StringBuilder();
        for (Student s : students) {
            sb.append(s.name).append("\n");
        }

        System.out.println(sb);
    }

    static class Student {
        String name;
        int a;
        int b;
        int c;

        Student(String name, int a, int b, int c) {
            this.name = name;
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}
