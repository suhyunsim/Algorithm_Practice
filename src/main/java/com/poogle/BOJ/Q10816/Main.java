package main.java.com.poogle.BOJ.Q10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(upperIndex(target, n) - lowerIndex(target, n)).append(" ");
        }
        System.out.println(sb);
    }

    private static int upperIndex(int target, int len) {
        int start = 0;
        int end = len;
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] > target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private static int lowerIndex(int target, int n) {
        int start = 0;
        int end = n;
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
