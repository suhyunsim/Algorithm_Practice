package main.java.com.poogle.BOJ.Q15652;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] a = new int[10];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
/*        순서로 풀이
        go(0, 1, n, m);
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
*/
//        선택으로 풀이
        System.out.println(go(1, 0, n, m));
    }

/*    순서로 풀이
    private static void go(int index, int start, int n, int m) {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]);
                if (i != m - 1)
                    sb.append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i <= n; i++) {
            arr[index] = i;
            go(index + 1, i, n, m);
        }
    }
 */
    static StringBuilder go(int index, int selected, int n, int m) {
        if (selected == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= a[i]; j++) {
                    sb.append(i);
                    sb.append(" ");
                }
            }
            sb.append("\n");
            return sb;
        }
        StringBuilder ans = new StringBuilder();
        if (index > n) return ans;
        //사전순으로 출력할 때 중복값과 아닌 값이 섞여있을 경우
        for (int i = m - selected; i >= 1; i--) {
            a[index] = i;
            ans.append(go(index + 1, selected + i, n, m));
        }
        a[index] = 0;
        ans.append(go(index + 1, selected, n, m));
        return ans;
    }
}
