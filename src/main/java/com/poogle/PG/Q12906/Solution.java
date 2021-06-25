package main.java.com.poogle.PG.Q12906;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static int[] solution(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            while (arr[i] == arr[i + 1]) {
                arr[i] = -1;
            }
        }
        List<Integer> list = Arrays.stream(arr)
                .boxed().collect(Collectors.toList());
        list.removeAll(Collections.singleton(-1));
        return list.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
//        int[] arr = {1, 1, 3, 3, 0, 1, 1};
        int[] arr = {4, 4, 4, 3, 3};
        System.out.println(Arrays.toString(solution(arr)));
    }
}
