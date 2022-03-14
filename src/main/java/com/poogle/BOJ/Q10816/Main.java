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

    /*
    상한: 찾으려는 값 초과한 값이 처음으로 나타나는 위치
    상한 값을 찾으려면 탐색 구간의 하한선을 올려야 함
     */
    private static int upperIndex(int target, int len) {
        int start = 0;
        int end = len;
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] > target) {
                end = mid;
            } else {
                //arr[mid] == target -> start를 늘림
                start = mid + 1;
            }
        }
        return start;
    }

    /*
    하한: 찾으려는 값 이상의 값이 처음으로 나타나는 위치
    하한 값을 찾으려면 탐색 구간의 상한선을 내려야 함
     */
    private static int lowerIndex(int target, int len) {
        int start = 0;
        int end = len;
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] >= target) {
                //arr[mid] == target -> end를 줄임
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
