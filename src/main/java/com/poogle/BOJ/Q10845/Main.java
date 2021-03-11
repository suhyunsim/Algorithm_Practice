package main.java.com.poogle.BOJ.Q10845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        int last = 0;
        while (n-- > 0) {
            String[] command = br.readLine().split(" ");
            switch (command[0]) {
                case "push":
                    last = Integer.parseInt(command[1]);
                    queue.offer(last);
                    break;
                case "pop":
                    if (!queue.isEmpty()) System.out.println(queue.poll());
                    else System.out.println("-1");
                    break;
                case "size":
                    System.out.println(queue.size());
                    break;
                case "empty":
                    if (!queue.isEmpty()) System.out.println("0");
                    else System.out.println("1");
                    break;
                case "front":
                    if (!queue.isEmpty()) System.out.println(queue.peek());
                    else System.out.println("-1");
                    break;
                case "back":
                    if (!queue.isEmpty()) System.out.println(last);
                    else System.out.println("-1");
                    break;
                default:
                    break;
            }
        }
        br.close();
    }
}
