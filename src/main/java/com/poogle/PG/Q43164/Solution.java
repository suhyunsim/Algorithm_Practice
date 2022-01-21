package main.java.com.poogle.PG.Q43164;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    static boolean[] visited;
    static List<String> result;
    static final String START = "ICN";

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}})));
        System.out.println(Arrays.toString(solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}})));
    }

    public static String[] solution(String[][] tickets) {
        int cnt = 0;
        visited = new boolean[tickets.length];
        result = new ArrayList<>();
        Arrays.sort(tickets, ((o1, o2) -> {
            if (o1[0].equals(o2[0])) {
                return o1[1].compareTo(o2[1]);
            }
            return o1[0].compareTo(o2[0]);
        }));
        dfs(cnt, START, START, tickets);
        return result.get(0).split(" ");
    }

    private static void dfs(int cnt, String now, String route, String[][] tickets) {
        if (cnt == tickets.length) {
            result.add(route);
            return;
        }
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(now)) {
                visited[i] = true;
                dfs(cnt + 1, tickets[i][1], route + " " + tickets[i][1], tickets);
                visited[i] = false;
            }
        }
    }
}
