package main.java.com.poogle.BOJ.Q1406;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split("");
        List<Character> list = new ArrayList<>();
        int index = str.length;
        for (String s : str) {
            list.add(s.charAt(0));
        }
        int m = Integer.parseInt(br.readLine());
        int len = index;

        while (m-- > 0) {
            char[] input = br.readLine().toCharArray();
            switch (input[0]) {
                case 'L':
                    if (index != 0)
                        index--;
                    break;
                case 'D':
                    if (index != len)
                        index++;
                    break;
                case 'B':
                    if (index != 0)
                        list.remove(--index);
                    break;
                default:
                    list.add(index++, input[2]);
                    len++;
                    break;
            }
        }
        for (char c : list) {
            bw.write(c);
        }
        bw.flush();
    }
}
