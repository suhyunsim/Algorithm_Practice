package main.java.com.poogle.BOJ.Q2108;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        //입력값 범위가 -4000 ~ 4000
        int[] arr = new int[8001];
        /*
        sum: 합
        max: 최대
        min: 최소
        median: 중앙값
        mode: 최빈값
         */
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        //-4000~4000 범위 제외한 값으로 초기화
        int median = 10000;
        int mode = 10000;

        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());
            sum += value;
            arr[value + 4000]++;

            if (max < value) {
                max = value;
            }
            if (min > value) {
                min = value;
            }
        }

        //중앙값 빈도 누적 수
        int cnt = 0;
        //최빈값의 최댓값
        int mode_max = 0;
        //최빈값 중복여부
        boolean flag = false;

        for (int i = min + 4000; i <= max + 4000; i++) {
            if (arr[i] > 0) {
                //중앙값 찾기
                if (cnt < (n + 1) / 2) {
                    cnt += arr[i];
                    median = i - 4000;
                }
                //최빈값 찾기 - 이전 최빈값보다 현재 값의 빈도수가 더 높은 경우
                if (mode_max < arr[i]) {
                    mode_max = arr[i];
                    mode = i - 4000;
                    flag = true;
                //이전 최빈값 최댓값과 동일한 경우면서 한 번만 중복되는 경우
                } else if (mode_max == arr[i] && flag) {
                    mode = i - 4000;
                    flag = false;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Math.round((double) sum / n));
        sb.append("\n");
        sb.append(median);
        sb.append("\n");
        sb.append(mode);
        sb.append("\n");
        sb.append(max - min);
        bw.write(String.valueOf(sb));
        br.close();
        bw.flush();
        bw.close();
    }

}
