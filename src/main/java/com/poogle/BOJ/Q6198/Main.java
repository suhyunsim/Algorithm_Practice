package main.java.com.poogle.BOJ.Q6198;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        Stack<Long> building = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long sum = 0L;
        building.push(Long.parseLong(br.readLine()));
        for (int i = 1; i < N; i++) {
            Long now = Long.parseLong(br.readLine());
            if (now >= building.peek())
                while (!building.isEmpty() && now >= building.peek())
                    building.pop();
            sum += building.size();
            building.push(now);
        }
        System.out.print(sum);
    }
}
