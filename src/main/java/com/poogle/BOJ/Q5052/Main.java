package main.java.com.poogle.BOJ.Q5052;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] numbers = new String[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = br.readLine();
            }
            Arrays.sort(numbers);
            boolean flag = false;
            for (int i = 1; i < n; i++) {
                if (numbers[i].startsWith(numbers[i - 1])) {
                    sb.append("NO").append("\n");
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                sb.append("YES").append("\n");
            }
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}
