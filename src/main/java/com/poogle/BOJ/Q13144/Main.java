package main.java.com.poogle.BOJ.Q13144;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        arr = new int[N + 1];

        for (int i = 1; i <= N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        bw.write(String.valueOf(twoPointer()));
        bw.flush();
        bw.close();
        br.close();
    }

    private static long twoPointer() {
        // 초기화
        int start = 1;
        int end = 0;
        long cnt = 0;
        int[] check = new int[N + 1];

        while (start <= N) {
            // 다음 수가 중복 아닐 때 end++, check++
            while (end + 1 <= N && check[arr[end + 1]] == 0) {
                end++;
                check[arr[end]]++;
            }
            cnt += end - start + 1;
            check[arr[start++]]--;
        }
        return cnt;
    }
}
