package main.java.com.poogle.BOJ.Q11286;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            if (Math.abs(o1) > Math.abs(o2)) return 1;
            else {
                if (Math.abs(o1) == Math.abs(o2)) return o1 - o2;
                else return -1;
            }
        });
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (num == 0) {
                if (priorityQueue.isEmpty()) System.out.println("0");
                else System.out.println(priorityQueue.poll());
            } else {
                priorityQueue.add(num);
            }
        }
    }
}
