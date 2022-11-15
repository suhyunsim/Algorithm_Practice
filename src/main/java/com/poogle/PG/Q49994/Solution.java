package main.java.com.poogle.PG.Q49994;


import java.util.HashSet;
import java.util.Set;

class Solution {
    public static int solution(String dirs) {
        String[] cmds = dirs.split("");
        Set<String> routeSet = new HashSet<>();
        int nowX = 0;
        int nowY = 0;
        for (String cmd : cmds) {
            StringBuilder route = new StringBuilder();
            int nextX = nowX;
            int nextY = nowY;
            switch (cmd) {
                case "U":
                    nextY++;
                    route.append(nowX).append(nowY).append(nextX).append(nextY);
                    break;
                case "R":
                    nextX++;
                    route.append(nowX).append(nowY).append(nextX).append(nextY);
                    break;
                case "D":
                    nextY--;
                    route.append(nextX).append(nextY).append(nowX).append(nowY);
                    break;
                case "L":
                    nextX--;
                    route.append(nextX).append(nextY).append(nowX).append(nowY);
                    break;
            }
            if (nextX > 5 || nextX < -5 || nextY > 5 || nextY < -5)
                continue;
            routeSet.add(String.valueOf(route));
            nowX = nextX;
            nowY = nextY;
        }
        return routeSet.size();
    }

    public static void main(String[] args) {
        System.out.println(solution("ULURRDLLU"));
        System.out.println(solution("LULLLLLLU"));
    }

}