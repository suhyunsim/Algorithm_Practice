package main.java.com.poogle.BOJ.Q6064;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] test = br.readLine().split(" ");
            int m = Integer.parseInt(test[0]);
            int n = Integer.parseInt(test[1]);
            int x = Integer.parseInt(test[2]) - 1;
            int y = Integer.parseInt(test[3]) - 1;
            boolean flag = false;
            for (int i = x; i < n * m; i += m) {
                if (i % n == y) {
                    System.out.println(i + 1);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                System.out.println(-1);
            }
        }
        br.close();
    }
}
