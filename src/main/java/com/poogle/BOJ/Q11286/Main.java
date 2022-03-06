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
        /* 같은 Comparable인데 다르게 표현할 수도 있음, 절댓값이 같으면 실제 숫자 기준으로, 아니라면 절댓값을 기준으로 오름차순 정렬
        PriorityQueue<Integer> queue = new PriorityQueue<>(((o1, o2) ->
        Math.abs(o1) == Math.abs(o2) ? Integer.compare(o1, o2) : Integer.compare(Math.abs(o1), Math.abs(o2))
        ));
        */
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
