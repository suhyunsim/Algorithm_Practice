package main.java.com.poogle.BOJ.Q1766;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<Integer>[] array = new ArrayList[N + 1];

        int[] indegree = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            array[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            array[n1].add(n2);
            indegree[n2]++;
        }

        String result = topologicalSort(indegree, array);

        bw.write(result);
        bw.flush();
        bw.close();
        br.close();
    }

    private static String topologicalSort(int[] indegree, List<Integer>[] array) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (Integer i : array[node]) {
                indegree[i]--;
                if (indegree[i] == 0) {
                    queue.offer(i);
                }
            }
            sb.append(node).append(" ");
        }
        return String.valueOf(sb);
    }
}
