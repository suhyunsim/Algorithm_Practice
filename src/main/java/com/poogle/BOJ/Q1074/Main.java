package main.java.com.poogle.BOJ.Q1074;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = stringToInt(st.nextToken());
        int r = stringToInt(st.nextToken());
        int c = stringToInt(st.nextToken());

        bw.write(String.valueOf(calculate(N, r, c)));
        bw.flush();
        bw.close();
    }

    private static int calculate(int N, int r, int c) {
        if (N == 0) return 0;
        int half = 1 << N - 1;
        if (r < half && c < half) return calculate(N - 1, r, c);
        if (r < half && c >= half) return half * half + calculate(N - 1, r, c - half);
        if (r >= half && c < half) return half * half * 2 + calculate(N - 1, r - half, c);
        return half * half * 3 + calculate(N-1, r - half, c - half);
    }

    public static int stringToInt(String st) {
        return Integer.parseInt(st);
    }
}
