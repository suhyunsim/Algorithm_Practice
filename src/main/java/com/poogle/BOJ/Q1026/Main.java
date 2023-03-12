package main.java.com.poogle.BOJ.Q1026;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int[] aArr = new int[N];
        int[] bArr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            aArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(aArr);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            bArr[i] = Integer.parseInt(st.nextToken());
        }
        List<Integer> reverseB = Arrays.stream(bArr).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += aArr[i] * reverseB.get(i);
        }

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
        br.close();
    }
}
