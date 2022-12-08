package main.java.com.poogle.PG.Q17680;

import java.util.*;

class Solution {
    public static int solution(int cacheSize, String[] cities) {
        //cache miss
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        //cache hit
        int answer = 0;
        LinkedList<String> list = new LinkedList<>();
        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toUpperCase();
            if (list.remove(city)) { //해당 값이 있으면
                answer += 1;
                list.add(city);
            } else {
                answer += 5;
                if (list.size() >= cacheSize) {
                    list.remove(0);
                }
                list.add(city);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
    }
}

