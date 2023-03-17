package main.java.com.poogle.BOJ.Q4803;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Integer>[] tree;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = 1;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            if (n1 == 0 && n2 == 0)
                break;
            tree = new ArrayList[n1 + 1];
            visited = new boolean[n1 + 1];
            int cnt = 0;

            for (int i = 1; i <= n1; i++) {
                tree[i] = new ArrayList<>();
            }

            for (int i = 0; i < n2; i++) {
                st = new StringTokenizer(br.readLine());
                int node1 = Integer.parseInt(st.nextToken());
                int node2 = Integer.parseInt(st.nextToken());
                tree[node1].add(node2);
                tree[node2].add(node1);
            }

            for (int i = 1; i <= n1; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    if (dfs(0, i))
                        cnt++;
                }
            }

            sb.append("Case ").append(T).append(": ");
            if (cnt == 0) {
                sb.append("No trees.");
            } else if (cnt == 1) {
                sb.append("There is one tree.");
            } else {
                sb.append("A forest of ").append(cnt).append(" trees.");
            }
            sb.append("\n");
            T++;
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean dfs(int root, int num) {
        for (int i : tree[num]) {
            if (i == root)
                continue;
            if (visited[i])
                return false;
            visited[i] = true;
            if (!dfs(num, i))
                return false;
        }
        return true;
    }
}
