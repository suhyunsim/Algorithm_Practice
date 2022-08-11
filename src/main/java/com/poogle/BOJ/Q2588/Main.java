package main.java.com.poogle.BOJ.Q2588;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int numberA = Integer.parseInt(st.nextToken());
        String n = br.readLine();
        String[] numberB = n.split("");
        for (int i = 0; i < 3; i++) {
            sb.append(numberA * Integer.parseInt(numberB[2 - i]));
            sb.append(System.getProperty("line.separator"));
        }
        sb.append(Integer.parseInt(n) * numberA);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}