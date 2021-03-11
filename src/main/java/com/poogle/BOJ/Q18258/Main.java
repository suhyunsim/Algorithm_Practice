package main.java.com.poogle.BOJ.Q18258;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        int last = 0;
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            switch (st.nextToken()) {
                case "push":
                    last = Integer.parseInt(st.nextToken());
                    queue.offer(last);
                    break;
                case "pop":
                    if (!queue.isEmpty()) sb.append(queue.poll()).append('\n');
                    else sb.append(-1).append('\n');
                    break;
                case "size":
                    sb.append(queue.size()).append('\n');
                    break;
                case "empty":
                    if (!queue.isEmpty()) sb.append("0").append('\n');
                    else sb.append(1).append('\n');
                    break;
                case "front":
                    if (!queue.isEmpty()) sb.append(queue.peek()).append('\n');
                    else sb.append(-1).append('\n');
                    break;
                case "back":
                    if (!queue.isEmpty()) sb.append(last).append('\n');
                    else sb.append(-1).append('\n');
                    break;
                default:
                    break;
            }
        }
        System.out.println(sb);
        br.close();
    }
}
