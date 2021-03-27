package main.java.com.poogle.BOJ.Q17425;

import java.io.*;

public class Main {
    static final int MAX = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long[] d = new long[MAX + 1]; //d: i의 약수의 합

        for (int i = 1; i <= MAX; i++) {
            d[i] = 1;
        }

        for (int i = 2; i <= MAX; i++) { //i를 약수로 갖는 모든 수
            for (int j = 1; i * j <= MAX; j++) { //i의 배수를 찾기
                d[i * j] += i;
            }
        }
        long[] s = new long[MAX + 1];

        for (int i = 1; i <= MAX; i++) {
            s[i] = s[i - 1] + d[i]; //s[i]는 d[1] ~ d[i]까지의 합
       }
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            bw.write(s[n] + "\n");
        }
        bw.flush();
        br.close();
    }
}
