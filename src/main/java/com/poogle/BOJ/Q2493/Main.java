package main.java.com.poogle.BOJ.Q2493;


import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

class Building {
    int num;
    int height;

    Building(int num, int height) {
        this.num = num;
        this.height = height;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Stack<Building> stack = new Stack<>();
        StringBuilder answer = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            int height = Integer.parseInt(st.nextToken());

            if (stack.isEmpty()) { //초기 설정
                answer.append("0 ");
                stack.push(new Building(i, height));
            } else {
                while (true) {
                    if (stack.isEmpty()) { //스택이 비어있으면 0 출력하고 탑 push
                        answer.append("0 ");
                        stack.push(new Building(i, height));
                        break;
                    }
                    Building building = stack.peek();

                    if (building.height > height) { //peek탑 높이가 현재 높이보다 놓으면
                        answer.append(building.num).append(" "); //peek탑 번호 출력
                        stack.push(new Building(i, height)); //현재 탑을 스택에 push
                        break;
                    } else { //peek탑 높이가 현재 높이보다 낮으면
                        stack.pop(); //peek탑 pop하고 while(true) 반복
                    }
                }
            }
        }
        bw.write(answer.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
