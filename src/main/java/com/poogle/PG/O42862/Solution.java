package main.java.com.poogle.PG.O42862;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] arr = new int[n];
        List<Integer> lostList = Arrays.stream(lost)
                .boxed()
                .collect(Collectors.toList());
        List<Integer> reverseList = Arrays.stream(reserve)
                .boxed()
                .collect(Collectors.toList());
        for (int i = 0; i < n; i++) {
            arr[i] += 1;
            if (lostList.contains(i + 1)) arr[i] -= 1;
            if (reverseList.contains(i + 1)) arr[i] += 1;
        }
        if (arr[0] == 0) {
            if (arr[1] == 2) {
                arr[0] += 1;
                arr[1] -= 1;
            }
        }
        if (arr[n - 1] == 0) {
            if (arr[n - 2] == 2) {
                arr[n - 1] += 1;
                arr[n - 2] -= 1;
            }
        }
        if (arr.length <= 3) {
            for (int j : arr) {
                if (j >= 1) answer++;
            }
            return answer;
        }
        for (int i = 1; i < n - 1; i++) {
            if (arr[i] == 0) {
                if (arr[i - 1] == 2) {
                    arr[i - 1] -= 1;
                    arr[i] += 1;
                } else if (arr[i + 1] == 2) {
                    arr[i + 1] -= 1;
                    arr[i] += 1;
                }
            }
        }
        for (int j : arr) {
            if (j >= 1) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(3, new int[]{1, 2}, new int[]{1}));
    }
}
