package main.java.com.poogle.BOJ.Q21276;

import java.io.*;
import java.util.*;

public class Main {

    static int N;

    static int[] inDegree;

    static List<List<Integer>> list;

    static String[] people;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        people = br.readLine().split(" ");
        Arrays.sort(people);

        // <정렬된 이름, 인덱스>
        Map<String, Integer> map = new HashMap<>();
        int i = 0;
        list = new ArrayList<>();
        for (String person : people) {
            map.put(person, i++);
            list.add(new ArrayList<>());
        }

        // 진입차수 배열
        inDegree = new int[N];

        int M = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int j = 0; j < M; j++) {
            st = new StringTokenizer(br.readLine());
            int childrenIndex = map.get(st.nextToken());
            int parentIndex = map.get(st.nextToken());

            //조상인덱스에 자손 인덱스 넣기 (조상 -> 자손)
            list.get(parentIndex).add(childrenIndex);
            //자손 진입차수 ++
            inDegree[childrenIndex]++;
        }

        topologySort();

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }

    private static void topologySort() {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> root = new ArrayList<>();
        List<List<Integer>> children = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            //시조일 때 큐, 리스트에 인덱스 추가
            if (inDegree[i] == 0) {
                root.add(i);
                queue.offer(i);
            }
            children.add(new ArrayList<>());
        }

        //위상정렬
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            // 현재의 자손 조사
            for (int next : list.get(curr)) {
                // 자손 진입차수 --
                inDegree[next]--;

                if (inDegree[next] == 0) {
                    children.get(curr).add(next);
                    queue.offer(next);
                }
            }
        }
        sb.append(root.size()).append("\n");
        for (int i : root) {
            sb.append(people[i]).append(" ");
        }
        sb.append("\n");
        for (int i = 0; i < N; i++) {
            sb.append(people[i]).append(" ").append(children.get(i).size()).append(" ");
            // 오름차순 정렬
            children.get(i).sort(null);
            for (int j : children.get(i)) {
                sb.append(people[j]).append(" ");
            }
            sb.append("\n");
        }
    }
}
