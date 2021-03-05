package main.java.com.poogle.BOJ.Q3273;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.parallelSort(list);
        int x = Integer.parseInt(br.readLine());

        int cnt = 0;
        int start = 0;
        int end = n - 1;
        int sum = 0;
        while (start < end) {
            sum = list[start] + list[end];
            if (sum == x) {
                cnt++;
            }
            if (sum <= x) {
                start++;
            } else {
                end--;
            }
        }

        System.out.println(cnt);
    }
}
