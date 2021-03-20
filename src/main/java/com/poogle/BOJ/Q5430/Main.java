package main.java.com.poogle.BOJ.Q5430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); //4

        for (int tc = 1; tc <= t; tc++) {
            String command = br.readLine(); //rdd
            int n = Integer.parseInt(br.readLine()); //4
            String numC = br.readLine(); //[1,2,3,4]
            Deque<Integer> deque = new LinkedList<>();
            for (String s : numC.substring(1, numC.length() - 1).split(",")) {
                if (!s.equals(""))
                    deque.addLast(Integer.valueOf(s));
            }
            System.out.println(ac(deque, command));
        }
    }

    static String ac(Deque<Integer> deque, String commands) {
        boolean reverse = false;

        for (char command : commands.toCharArray()) {
            if (command == 'R')
                reverse = !reverse;
            else {
                if (deque.size() == 0)
                    return "error";
                if (reverse)
                    deque.removeLast();
                else
                    deque.removeFirst();
            }
        }

        StringBuilder sb = new StringBuilder("[");

        while (!deque.isEmpty()) {
            sb.append(reverse ? deque.removeLast() : deque.removeFirst());
            if (deque.size() != 0)
                sb.append(',');
        }
        sb.append(']');
        return sb.toString();
    }
}
