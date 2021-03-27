package main.java.com.poogle.BOJ.Q10430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] list = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int a = list[0];
        int b = list[1];
        int c = list[2];
        System.out.println((a + b) % c);
        System.out.println((a + b) % c);
        System.out.println((a * b) % c);
        System.out.println((a * b) % c);
        br.close();
    }
}
