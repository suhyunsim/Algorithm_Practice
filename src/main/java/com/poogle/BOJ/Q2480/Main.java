package main.java.com.poogle.BOJ.Q2480;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int sameValue;
        boolean isSame = false;
        int high = a > b ? (Math.max(a, c)) : (Math.max(b, c));
        if (a == b) {
            sameValue = a;
            isSame = true;
        } else if (b == c) {
            sameValue = b;
            isSame = true;
        } else if (a == c) {
            sameValue = a;
            isSame = true;
        } else {
            sameValue = 0;
        }
        StringBuilder sb = new StringBuilder();

        if ((a == b) && (b == c)) {
            sb.append(a * 1000 + 10000);
        } else if (a == b || b == c || a == c) {
            if (isSame) {
                sb.append(sameValue * 100 + 1000);
            }
        } else {
            sb.append(high * 100);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
