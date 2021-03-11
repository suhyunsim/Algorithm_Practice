package main.java.com.poogle.BOJ.Q10866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            switch (st.nextToken()) {
                case "push_front":
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    if (!deque.isEmpty()) sb.append(deque.pollFirst()).append('\n');
                    else sb.append(-1).append('\n');
                    break;
                case "pop_back":
                    if (!deque.isEmpty()) sb.append(deque.pollLast()).append('\n');
                    else sb.append(-1).append('\n');
                    break;
                case "size":
                    sb.append(deque.size()).append('\n');
                    break;
                case "empty":
                    if (!deque.isEmpty()) sb.append(0).append('\n');
                    else sb.append(1).append('\n');
                    break;
                case "front":
                    if (!deque.isEmpty()) sb.append(deque.peek()).append('\n');
                    else sb.append(-1).append('\n');
                    break;
                case "back":
                    if (!deque.isEmpty()) sb.append(deque.peekLast()).append('\n');
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
