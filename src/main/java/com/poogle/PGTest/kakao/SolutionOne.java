package main.java.com.poogle.PGTest.kakao;

import java.util.ArrayList;
import java.util.List;

//lv 1 2
public class SolutionOne {
    public static int solution(String s) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                list.add(Integer.parseInt(String.valueOf(s.charAt(i))));
            } else {
                if (s.charAt(i) == 'z') {
                    list.add(0);
                    i += 3;
                } else if (s.charAt(i) == 'o') {
                    list.add(1);
                    i += 2;
                } else if (s.charAt(i) == 'e') {
                    list.add(8);
                    i += 4;
                } else if (s.charAt(i) == 'n') {
                    list.add(9);
                    i += 3;
                } else if (s.charAt(i) == 't') {
                    if (s.charAt(i + 1) == 'w') {
                        list.add(2);
                        i += 2;
                    } else {
                        list.add(3);
                        i += 4;
                    }
                } else if (s.charAt(i) == 'f') {
                    if (s.charAt(i + 1) == 'o') {
                        list.add(4);
                    } else {
                        list.add(5);
                    }
                    i += 3;
                } else if (s.charAt(i) == 's') {
                    if (s.charAt(i + 1) == 'i') {
                        list.add(6);
                    } else {
                        list.add(7);
                        i += 4;
                    }
                }
            }
        }
        System.out.println(list);
        int answer = 0;
        int size = list.size();
        for (int i = size; i > 0; i--) {
             answer += list.get(size - i) * Math.pow(10, i - 1);
        }
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        solution("onetwothree");
    }
}
