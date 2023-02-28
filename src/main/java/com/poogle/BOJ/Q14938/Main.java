package main.java.com.poogle.BOJ.Q14938;

import java.io.*;
import java.util.*;

public class Main {
    static int n, m, r;

    // 각 지역에서 얻을 수 있는 아이템 베열
    static int[] items;

    // 양방향 인접 리스트
    static List<List<Region>> list = new ArrayList<>();

    // 최단거리 배열
    static int[] dist;

    // 시작 ~ 현재까지 최단 거리인지 체크
    static boolean[] checked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        items = new int[n + 1];
        dist = new int[n + 1];
        checked = new boolean[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 1; i <= r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list.get(a).add(new Region(b, weight));
            list.get(b).add(new Region(a, weight));
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, dijkstra(i));
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }

    private static int dijkstra(int start) {
        // 최단 거리 갱신을 위해 max 값 초기화
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(checked, false);

        PriorityQueue<Region> priorityQueue = new PriorityQueue<>();
        // 시작과 자기 자신과의 거리는 0
        priorityQueue.offer(new Region(start, 0));
        dist[start] = 0;

        while (!priorityQueue.isEmpty()) {
            // weight가 작은 것부터 poll
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

        // 탐색 범위 이하인지 확인
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] <= m)
                result += items[i];
        }
        return result;
    }

}

class Region implements Comparable<Region> {
    int number, weight;

    public Region(int number, int weight) {
        this.number = number;
        this.weight = weight;
    }

    // 거리 기준 오름차순 정렬을 위한 함수
    @Override
    public int compareTo(Region o) {
        return weight - o.weight;
    }
}
