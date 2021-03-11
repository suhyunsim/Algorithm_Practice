package main.java.com.poogle.BOJ.Q2164;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> cards = new LinkedList<>();
        for (int i = 1; i <= n; i++){
            cards.offer(i);
        }
        int i = 1;
        while (cards.size() != 1) {
            if (i % 2 == 1) {
                cards.poll();
            } else {
                cards.offer(cards.poll());
            }
            i++;
        }
        bw.write(cards.peek() + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
