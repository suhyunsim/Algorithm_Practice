package main.java.com.poogle.BOJ.Q1753;

import java.io.*;
import java.util.*;

public class Main {
    static int[] distance;
    static List<Node>[] list;
    static int v;
    static int e;
    static int k;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());

        distance = new int[v + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        list = new ArrayList[v + 1];
        for (int i = 1; i <= v; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end, weight));
        }

        dijkstra(k);

        for (int i = 1; i <= v; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                sb.append("INF\n");
            } else {
                sb.append(distance[i]).append("\n");
            }
        }
        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        distance[start] = 0;
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (now.weight > distance[now.start]) continue;
            int len = list[now.start].size();
            for (int i = 0; i < len; i++) {
                Node next = list[now.start].get(i);
                if (distance[next.start] > now.weight + next.weight) {
                    distance[next.start] = now.weight + next.weight;
                    queue.add(new Node(next.start, distance[next.start]));
                }
            }
        }

    }

    static class Node implements Comparable<Node> {
        int start, weight;

        public Node(int start, int weight) {
            this.start = start;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

}

