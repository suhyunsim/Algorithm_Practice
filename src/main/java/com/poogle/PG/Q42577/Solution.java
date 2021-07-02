package main.java.com.poogle.PG.Q42577;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        System.out.println(Arrays.toString(phone_book));
//        if (phone_book.length == 1) return false;
//        for (int i = 0; i < phone_book.length - 1; i++) {
//            for (int j = i + 1; j < phone_book.length; j++) {
//                if (phone_book[j].startsWith(phone_book[i])) return false;
//            }
//        }
        Map<String, String> map = new HashMap<>();
        for (String n : phone_book) {
            map.put(n, n);
        }
        for (String n : phone_book) {
            for (int i = 0; i < n.length(); i++) {
                String tmp = n.substring(0, i);
                if (map.containsKey(tmp)) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"1195524421", "97674223", "119"}));
        System.out.println(solution(new String[]{"14", "245", "24", "599"}));
    }
}
