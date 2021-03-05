package main.java.com.poogle.BOJ.Q1919;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = 0;
        String word1 = scan.next();
        String word2 = scan.next();

        // 단어별로 알파벳 담을 배열
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for (int i = 0; i < word1.length(); i++)
            arr1[word1.charAt(i) - 'a']++;

        for (int i = 0; i < word2.length(); i++)
            arr2[word2.charAt(i) - 'a']++;

        // 각 알파벳 별로 차이만큼(절댓값) 제거하기
        for (int i = 0; i < 26; i++)
            if (arr1[i] != arr2[i])
                count += Math.abs(arr1[i] - arr2[i]);

        System.out.println(count);
        scan.close();
    }
}
