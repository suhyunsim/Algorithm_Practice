package main.java.com.poogle.CD.L2.CyclicRotation;


import java.util.Arrays;

class Solution {
    public static int[] solution(int[] A, int K) {
        if (A == null || A.length <= 1)
            return A;
        for (int i = 0; i < K; i++) {
            int lastNum = A[A.length - 1];
            for (int j = A.length - 1; j > 0; j--) {
                A[j] = A[j - 1];
            }
            A[0] = lastNum;
        }
        return A;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{3, 8, 9, 7, 6}, 3)));
    }
}
