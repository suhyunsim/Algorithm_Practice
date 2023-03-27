package main.java.com.poogle.BOJ.Q1766;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSort {
    // 정점 수
    static int n;

    // 간선 수
    static int e;

    public static void main(String[] args) {
        n = 7;
        e = 9;

        // 해당 노드를 가리키는 간선 개수를 담은 배열
        int[] indegree = new int[n + 1];

        // 그래프 관계를 담은 인접리스트
        List<Integer>[] array = new ArrayList[e + 1];
        for (int i = 0; i <= n; i++) {
            array[i] = new ArrayList<>();
        }

        // v1 -> v2
        int[] v1 = new int[]{1, 1, 2, 4, 3, 3, 5, 2, 5};
        int[] v2 = new int[]{2, 3, 5, 6, 4, 7, 6, 4, 4};

        for (int i = 0; i < e; i++) {
            array[v1[i]].add(v2[i]);
            indegree[v2[i]]++;
        }

        topologicalSort(indegree, array);
    }

    private static void topologicalSort(int[] indegree, List<Integer>[] array) {
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> result = new LinkedList<>();

        // indegree 0인 노드 담기
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        /*
        1) 큐에서 값을 꺼내며 해당 노드가 가리키는 노드의 indegree--
        2) indegree가 0이 되면 큐에 넣기
        3) 큐가 빌 떄까지 반복
         */
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.offer(node);
            for (Integer i : array[node]) {
                indegree[i]--;
                if (indegree[i] == 0) {
                    queue.offer(i);
                }
            }

        }
        System.out.println(result);
    }
}
