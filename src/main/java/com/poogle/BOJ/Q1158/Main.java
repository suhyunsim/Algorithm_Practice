package main.java.com.poogle.BOJ.Q1158;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i < n + 1; i++) {
            queue.offer(i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append('<');
        while (queue.size() != 1) {
            for (int i = 0; i < k - 1; i++) {
                queue.offer(queue.poll());
            }
            sb.append(queue.poll()).append(", ");
        }
        sb.append(queue.poll()).append(">");
        bw.write(sb.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
