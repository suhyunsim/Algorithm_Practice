package main.java.com.poogle.BOJ.Q13549;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int max = 100000;
    static int min = Integer.MAX_VALUE;
    static int n, k;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        visited = new boolean[max + 1];
        bfs();
        System.out.println(min);
    }

    public static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(n, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            visited[node.x] = true;
            if (node.x == k) {
                min = Math.min(min, node.time);
            }
            if (node.x * 2 <= max && !visited[node.x * 2]) {
                queue.offer(new Node(node.x * 2, node.time));
            }
            if (node.x + 1 <= max && !visited[node.x + 1]) {
                queue.offer(new Node(node.x + 1, node.time + 1));
            }
            if (node.x - 1 >= 0 && !visited[node.x - 1]) {
                queue.offer(new Node(node.x - 1, node.time + 1));
            }
        }
    }
}

class Node {
    int x, time;

    public Node(int x, int time) {
        this.x = x;
        this.time = time;
    }
}