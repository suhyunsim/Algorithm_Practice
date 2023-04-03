package main.java.com.poogle.BOJ.Q1504;

import java.io.*;
import java.util.*;

public class Main {

    static int N, E;

    // 인접리스트
    static List<List<Region>> list = new ArrayList<>();

    // 방문 확인
    static boolean[] checked;

    // 시작점에서 각 정점으로 가는 최단거리
    static int[] dist;

    // 간선의 최대 개수: 200,000 * 가중치 최댓값: 1,000 => INF: 200,000,000
    static final int INF = 200000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            // 양방향 그래프
            list.get(start).add(new Region(end, distance));
            list.get(end).add(new Region(start, distance));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // 1 -> v1 -> v2 -> N
        int result1 = 0;
        result1 += dijkstra(1, v1);
        result1 += dijkstra(v1, v2);
        result1 += dijkstra(v2, N);

        // 1 -> v2 -> v1 -> N
        int result2 = 0;
        result2 += dijkstra(1, v2);
        result2 += dijkstra(v2, v1);
        result2 += dijkstra(v1, N);

        int answer = (result1 >= INF && result2 >= INF) ? -1 : Math.min(result1, result2);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }

    private static int dijkstra(int start, int end) {

        dist = new int[N + 1];
        checked = new boolean[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Region> pq = new PriorityQueue<>();
        pq.offer(new Region(start, 0));

        while (!pq.isEmpty()) {
            Region curr = pq.poll();
            int number = curr.number;
            if (!checked[number]) {
                checked[number] = true;
                // 인접 노드 조사
                for (Region region : list.get(number)) {
                    if (!checked[region.number] && dist[region.number] > dist[number] + region.distance) {
                        dist[region.number] = dist[number] + region.distance;
                        // 최소 거리로 업데이트 되는 노드만 큐에 넣기
                        pq.offer(new Region(region.number, dist[region.number]));
                    }
                }
            }
        }
        return dist[end];
    }
}

class Region implements Comparable<Region> {
    int number, distance;

    public Region(int number, int distance) {
        this.number = number;
        this.distance = distance;
    }

    @Override
    public int compareTo(Region o) {
        return this.distance - o.distance;
    }
}
