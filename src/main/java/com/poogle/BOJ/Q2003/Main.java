package main.java.com.poogle.BOJ.Q2003;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int cnt, N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        twoPointer();
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void twoPointer() {
        int start = 0, end = 0, sum = 0, cnt = 0;
        while (true) {
            if (sum >= M) {
                sum -= arr[start++];
            } else if (end >= arr.length) {
                break;
            } else {
                sum += arr[end++];
            }
            if (sum == M)
                cnt++;
        }
    }
}
