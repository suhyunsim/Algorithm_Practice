package main.java.com.poogle.BOJ.Q1427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        while (num > 0) {
            int c = num % 10;
            list.add(c);
            num /= 10;
        }
        Collections.sort(list);
        int result = 0;
        for (int i : list) {
            result += (int) (list.get(i) * Math.pow(10, i));
        }
        System.out.println(result);
    }
}
