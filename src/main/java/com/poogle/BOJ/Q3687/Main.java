package main.java.com.poogle.BOJ.Q3687;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int tc, n;
    static long[] minDp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            n = Integer.parseInt(br.readLine());
            //최솟값
            minDp = new long[101];
            Arrays.fill(minDp, Long.MAX_VALUE);
            minDp[2] = 1;
            minDp[3] = 7;
            minDp[4] = 4;
            minDp[5] = 2;
            minDp[6] = 6;
            minDp[7] = 8;
            minDp[8] = 10;
            int[] arr = {1, 7, 4, 2, 0, 8};

            for (int i = 9; i <= 100; i++) {
                for (int j = 2; j <= 7; j++) {
                    StringBuilder min = new StringBuilder();
                    min.append(minDp[i - j]).append(arr[j - 2]);
                    minDp[i] = Math.min(minDp[i], Long.parseLong(min.toString()));
                }
            }
            //최댓값
            StringBuilder max = new StringBuilder();
            long a = n / 2;
            long b = n % 2;

            if (b == 1) {
                max.append("7");
            } else {
                max.append("1");
            }
            for (int j = 1; j < a; j++) {
                max.append("1");
            }
            System.out.println(minDp[n] + " " + max.toString());
        }
    }
}