package main.java.com.poogle.BOJ.Q15649;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    //사용한지 여부를 알기 위해 (checked[i]: 사용했으면 true)
    static boolean[] checked = new boolean[10];
    //고른 수열을 저장
    static int[] array = new int[10];

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        go(0, N, M);
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }

    //index번 째의 수를 결정
    private static void go(int index, int n, int m) {
        //마지막 도착
        if (index == m) {
            for (int i = 0; i < m; i++) {
                sb.append(array[i]);
                if (i != m - 1)
                    sb.append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            // 1 ~ N 중에서 사용하지 않은 수 찾기
            if (!checked[i]) {
                //수 i를 사용하기
                array[index] = i;
                //함수 호출 전에 사용했다고 준비
                checked[i] = true;
                go(index + 1, n, m);
                //호출 후에 index에는 다른 i가 들어가야 함 -> 다른 i는 사용하지 않은 상태
                checked[i] = false;
            }
        }
    }

}
