package main.java.com.poogle.BOJ.Q16398;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] parents;
    static int N;

    // 간선 리스트
    static List<Edge> edgeList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                edgeList.add(new Edge(i, j, Integer.parseInt(st.nextToken())));
            }
        }

        // 정렬
        Collections.sort(edgeList);

        // 각 그룹의 부모 그룹 설정
        parents = new int[N];
        makeParents();

        // 최소 신장 트리는 n개의 정점을 가지는 그래프에 대해 반드시 n-1개의 간선을 사용
        int cnt = 0;

        // 관리 비용 최대 100,000,000 -> long
        long answer = 0;
        for (Edge edge : edgeList) {
            if (union(edge.from, edge.to)) {
                answer += edge.cost;
                cnt++;
                if (cnt == N - 1) break;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void makeParents() {
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }
    }

    private static boolean union(int from, int to) {
        int fromRoot = find(from);
        int toRoot = find(to);

        // cycle
        if (fromRoot == toRoot) return false;
        parents[toRoot] = fromRoot;
        return true;
    }

    // 속해있는 부모 그룹이 어디인지 찾기
    private static int find(int vertex) {
        if (parents[vertex] == vertex) return vertex;
        return parents[vertex] = find(parents[vertex]);
    }

}

class Edge implements Comparable<Edge> {

    int from, to, cost;

    public Edge(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}
