package main.java.com.poogle.BOJ.Q2251;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] volume = new int[3];
        for (int i = 0; i < volume.length; i++) {
            volume[i] = Integer.parseInt(st.nextToken());
        }
        boolean[] answer = new boolean[201]; //A가 비어있을 때 C 물의 양
        answer[volume[2]] = true;

        System.out.println(Arrays.toString(answer));

        int[] from = {0, 0, 1, 1, 2, 2};
        int[] to = {1, 2, 0, 2, 0, 1};

        //A, B 물의 값 방문 여부
        boolean[][] visited = new boolean[201][201];

        Queue<Bucket> queue = new LinkedList<>();

        //처음 A, B는 비어있음
        queue.add(new Bucket(0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Bucket now = queue.poll();
            int a = now.a;
            int b = now.b;
            int c = volume[2] - a - b; //처음 C에 담겨 있는 것이 총 물의 양

            for (int k = 0; k < 6; k++) {
                int[] next = {a, b, c};
                next[to[k]] += next[from[k]];
                next[from[k]] = 0;

                //용량 초과하면 넘친만큼 원래 물통으로 다시 넣어주기
                if (next[to[k]] > volume[to[k]]) {
                    next[from[k]] = next[to[k]] - volume[to[k]];
                    next[to[k]] = volume[to[k]];
                }

                if (!visited[next[0]][next[1]]) {
                    visited[next[0]][next[1]] = true;
                    queue.add(new Bucket(next[0], next[1]));

                    //A가 비어있을 때의 C의 물의 양
                    if (next[0] == 0) {
                        answer[next[2]] = true;
                        System.out.println(Arrays.toString(answer));
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= volume[2]; i++) {
            if (answer[i]) {
                sb.append(i).append(" ");
            }
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}

class Bucket {
    int a, b;

    public Bucket(int a, int b) {
        this.a = a;
        this.b = b;
    }
}