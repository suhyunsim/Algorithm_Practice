package main.java.com.poogle.BOJ.Q2493;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Stack<Building> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            int height = Integer.parseInt(st.nextToken());

            //초기 설정
            if (stack.isEmpty()) {
                sb.append("0 ");
                stack.push(new Building(i, height));
            } else {
                while (true) {
                    if (stack.isEmpty()) {
                        sb.append("0 ");
                        stack.push(new Building(i, height));
                        break;
                    }
                    Building building = stack.peek();

                    //peek한 탑의 높이가 현재 높이보다 높으면
                    if (building.height > height) {
                        //peek 탑 번호 출력
                        sb.append(building.num).append(" ");
                        //현재 탑 push하고 while(true) break
                        stack.push(new Building(i, height));
                        break;
                    //peek한 탑의 높이 현재 높이보다 낮으면
                    } else {
                        //pop하고 while(true)
                        stack.pop();
                    }
                }
            }
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}

class Building {
    int num;
    int height;

    Building(int num, int height) {
        this.num = num;
        this.height = height;
    }
}

