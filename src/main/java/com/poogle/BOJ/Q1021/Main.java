package main.java.com.poogle.BOJ.Q1021;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Deque<Integer> list = new LinkedList<>();
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        int m = sc.nextInt();
        while (m-- > 0) {
            int num = sc.nextInt();
            while (true) {
                int index = 0;
                for (Integer integer : list) {
                    if (integer.equals(num))
                        break;
                    index++;
                }
                if (index == 0) {
                    list.pollFirst();
                    break;
                } else if (index > list.size() / 2){
                    list.addFirst(list.removeLast());
                    cnt++;
                } else {
                    list.addLast(list.removeFirst());
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
