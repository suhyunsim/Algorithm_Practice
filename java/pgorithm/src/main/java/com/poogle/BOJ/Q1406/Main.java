package main.java.com.poogle.BOJ.Q1406;

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split("");
        LinkedList<Character> list = new LinkedList<>();
        ListIterator<Character> iterator = list.listIterator();

        for (String s : str) {
            iterator.add(s.charAt(0));
        }

        int m = Integer.parseInt(br.readLine());

        while (m-- > 0) {
            char[] input = br.readLine().toCharArray();
            switch (input[0]) {
                case 'L':
                    if (iterator.hasPrevious())
                        iterator.previous();
                    break;
                case 'D':
                    if (iterator.hasNext())
                        iterator.next();
                    break;
                case 'B':
                    if (iterator.hasPrevious()) {
                        iterator.previous();
                        iterator.remove();
                    }
                    break;
                default:
                    iterator.add(input[2]);
                    break;
            }
        }
        for (char c : list) {
            bw.write(c);
        }
        bw.flush();
    }
}
