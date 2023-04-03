package main.java.com.poogle.BOJ.Q1238;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, X;

    static List<List<Region>> forwardList = new ArrayList<>();
    static List<List<Region>> backwardList = new ArrayList<>();

    static boolean[] checked;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            forwardList.add(new ArrayList<>());
            backwardList.add(new ArrayList<>());
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int road = Integer.parseInt(st.nextToken());
            forwardList.get(start).add(new Region(end, road));
            backwardList.get(end).add(new Region(start, road));
        }
        int answer = Integer.MIN_VALUE;
        int[] forwardResult = dijkstra(forwardList);
        int[] backwardResult = dijkstra(backwardList);

        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, forwardResult[i] + backwardResult[i]);
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }

    private static int[] dijkstra(List<List<Region>> list) {

        dist = new int[N + 1];
        checked = new boolean[N + 1];

        // 초기화
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(checked, false);
        // 모든 정점에서 모든 정점에 대한 최단거리가 필요한 것이 아니라, 모든 정점에 대해서 X까지의 거리만 알면 됨
        // X를 시작점으로 설정
        dist[X] = 0;

        // 가까운 순서대로 처리 -> 큐
        PriorityQueue<Region> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new Region(X, 0));

        while (!priorityQueue.isEmpty()) {
            Region curr = priorityQueue.poll();
            int number = curr.number;
            if (!checked[number]) {
                checked[number] = true;
                for (Region region : list.get(number)) {
                    if (!checked[region.number] && dist[region.number] > dist[number] + region.weight) {
                        dist[region.number] = dist[number] + region.weight;
                        priorityQueue.offer(new Region(region.number, dist[region.number]));
                    }
                }
            }
        }
        return dist;
    }
}

class Region implements Comparable<Region> {
    int number, weight;

    public Region(int number, int weight) {
        this.number = number;
        this.weight = weight;
    }

    @Override
    public int compareTo(Region o) {
        return weight - o.weight;
    }
}
