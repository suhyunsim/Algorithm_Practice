package main.java.com.poogle.PGTest.kakao;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

//lv2 3
public class SolutionThree {
    public static String solution(int n, int k, String[] cmd) {
        Character[] list = new Character[n];
        Map<Integer, Integer> check = new HashMap<>();
        for (int i = 0; i < n; i++) {
            list[i] = 'O';
            check.put(i, 0);
        }
        for (int i = 0; i < cmd.length; i++) {
            if (cmd[i].charAt(0) == 'U') {
                k += cmd[i].charAt(1);
            } else if (cmd[i].charAt(0) == 'D') {
                k -= cmd[i].charAt(1);
            } else if (cmd[i].charAt(0) == 'C') {
                list[k] = 'X';
                check.put(k, i);
                k++;
            } else if (cmd[i].charAt(0) == 'Z') {
                int l = Collections.max(check.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
                list[l] = 'O';
                check.put(l, 0);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character character : list) {
            sb.append(character);
        }
        System.out.println(sb);
        return String.valueOf(sb);
    }

    public static void main(String[] args) {
        String[] test = {"D 1", "C"};
        solution(5, 2, test);
    }
}
