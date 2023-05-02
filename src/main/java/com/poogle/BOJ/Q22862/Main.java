package main.java.com.poogle.BOJ.Q22862;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] S = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken()) % 2 == 0;
        }

        int max = 0;
        int left = 0;
        int right = 0;
        int cnt = 0;

        while (right < N) {
            if (cnt < K) {
                // 홀수
                if (!S[right]) {
                    cnt++;
                }
                right++;
                max = Math.max(right - left - cnt, max);
            // cnt == K && 짝수
            } else if (S[right]) {
                right++;
                max = Math.max(right - left - cnt, max);
            // cnt == K
            } else {
                // left가 홀수라면 -1
                if (!S[left]) {
                    cnt--;
                }
                left++;
            }
        }
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
        br.close();
    }
}
