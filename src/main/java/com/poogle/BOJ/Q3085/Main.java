package main.java.com.poogle.BOJ.Q3085;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[][] candies = new String[n][n];
        for (int i = 0; i < n; i++) {
            candies[i] = br.readLine().split("");
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //행 확인
                if (j + 1 < n) {
                    //Swap
                    String swap = candies[i][j];
                    candies[i][j] = candies[i][j + 1];
                    candies[i][j + 1] = swap;
                    //몇 개인지 세기
                    int tmp = check(candies);
                    if (ans < tmp) ans = tmp;
                    //돌려놓기
                    swap = candies[i][j];
                    candies[i][j] = candies[i][j + 1];
                    candies[i][j + 1] = swap;
                }
                //열 확인
                if (i + 1 < n) {
                    String a = candies[i][j];
                    candies[i][j] = candies[i + 1][j];
                    candies[i + 1][j] = a;
                    //몇 개인지 세기
                    int tmp = check(candies);
                    if (ans < tmp) ans = tmp;
                    //돌려놓기
                    a = candies[i][j];
                    candies[i][j] = candies[i + 1][j];
                    candies[i + 1][j] = a;
                }
            }
        }
        bw.write(String.valueOf(ans));
        bw.flush();
        br.close();
    }

    private static int check(String[][] candies) {
        int n = candies.length;
        int ans = 1;
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 1; j < n; j++) {
                if (candies[i][j].equals(candies[i][j - 1])) {
                    cnt += 1;
                } else {
                    cnt = 1;
                }
                if (ans < cnt) ans = cnt;
            }
            cnt = 1;
            for (int j = 1; j < n; j++) {
                if (candies[j][i].equals(candies[j - 1][i])) {
                    cnt += 1;
                } else {
                    cnt = 1;
                }
                if (ans < cnt) ans = cnt;
            }
        }
        return ans;
    }
}
