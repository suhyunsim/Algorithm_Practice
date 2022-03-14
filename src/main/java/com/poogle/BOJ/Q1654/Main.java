package main.java.com.poogle.BOJ.Q1654;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        //min, max, mid 모두 long
        long max = arr[k - 1];
        long min = 1;

        while (max >= min) {
            long mid = (max + min) / 2;
            long cnt = 0;
            // 구해진 중간 길이로 잘라서 총 몇 개가 만들어지는지
            for (int i : arr) {
                cnt += i / mid;
            }
            if (cnt >= n) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        System.out.println(max);
    }
}
