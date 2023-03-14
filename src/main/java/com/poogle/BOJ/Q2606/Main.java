package main.java.com.poogle.BOJ.Q2606;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int cnt = 0;
    static boolean[] visited = new boolean[101];
    static List<Integer>[] graph = new ArrayList[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int l = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }

        dfs(1);

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int start) {
        cnt++;
        visited[start] = true;
        for (int i = 0; i < graph[start].size(); i++) {
            int num = graph[start].get(i);
            if (!visited[num]) {
                dfs(num);
            }
        }
    }
}
