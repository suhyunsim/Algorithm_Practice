package main.java.com.poogle.BOJ.Q11279;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        while (N-- > 0) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (priorityQueue.isEmpty()) {
                    bw.write("0");
                } else {
                    bw.write(String.valueOf(priorityQueue.poll()));
                }
                bw.write("\n");
            } else {
                priorityQueue.add(x);
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
