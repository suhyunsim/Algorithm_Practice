package main.java.com.poogle.BOJ.Q15650;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int M;
    static int N;

    static int[] result = new int[9];

    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        /* 순서
        go(0, 1, n, m);
         */

        //선택
        go(1, 0);
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }

    //선택으로 풀이
    private static void go(int index, int cnt) {
        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        if (index > N)
            return;
        result[cnt] = index;
        go(index + 1, cnt + 1);
        result[cnt] = 0;
        go(index + 1, cnt);
    }

    /* 순서로 풀이
    //index번 째에 올 수 있는 수의 범위의 시작: start
    static void go(int index, int start, int n, int m) {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(a[i]);
                if (i != m - 1) System.out.print(' ');
            }
            System.out.println();
            return;
        }
        for (int i = start; i <= n; i++) {
            a[index] = i;
            go(index + 1, i + 1, n, m);
        }
    }
    */
}
