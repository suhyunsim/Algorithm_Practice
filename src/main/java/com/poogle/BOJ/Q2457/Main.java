package main.java.com.poogle.BOJ.Q2457;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static final int START = 301;
    static final int END = 1201;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> flowers = new HashMap<>();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = getDates(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            int end = getDates(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            if (flowers.get(start) == null || flowers.get(start) < end) {
                flowers.put(start, end);
            }
        }
        boolean flag = false;
        int now = START;
        //11월 30일 전까지
        while (now < END) {
            int max = now;
            for (int key : flowers.keySet()) {
                /*
                지금보다 먼저 피는 꽃 중에서 가장 늦게 지는 꽃
                 */
                if (key <= now && max < flowers.get(key)) {
                    max = flowers.get(key);
                    flag = true;
                }
            }
            if (flag) {
                now = max;
                flag = false;
                cnt++;
            } else {
                /*
                1) 3/1 이후에만 피는 경우
                2) 중간에 아무 꽃도 안 피는 경우
                3) 모든 꽃이 11/30 이전에 지는 경우
                 */
                cnt = 0;
                break;
            }
        }
        System.out.println(cnt);

    }

    private static int getDates(int month, int day) {
        return month * 100 + day;
    }
}
