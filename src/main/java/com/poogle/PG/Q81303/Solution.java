package main.java.com.poogle.PG.Q81303;

import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solution(8, 2, new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"}));
    }

    private static String solution(int n, int k, String[] cmd) {
        Stack<Integer> removedStack = new Stack<>();
        int size = n;
        for (int i = 0; i < cmd.length; i++) {
            char c = cmd[i].charAt(0);
            if (c == 'D') {
                k += Integer.parseInt(cmd[i].substring(2));
            } else if (c == 'U') {
                k -= Integer.parseInt(cmd[i].substring(2));
            } else if (c == 'C') {
                removedStack.push(k);
                size--; //전체 크기 줄이기
                if (k == size) {
                    k--; //맨 아래면 현재 위치 하나 위로
                }
            } else if (c == 'Z') {
                if (removedStack.pop() <= k) {
                    k++; //위에서 들어가니까
                }
                size++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append("O");
        }
        while (!removedStack.isEmpty()) {
            sb.insert(removedStack.pop(), "X");
        }
        return sb.toString();
    }

    public String solutionLL(int n, int k, String[] cmd) {
        int[] pre = new int[n];
        int[] next = new int[n];
        for (int i = 0; i < n; i++) {
            pre[i] = i - 1;
            next[i] = i + 1;
        }
        next[n - 1] = -1;

        Stack<Node> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("O");
        }

        for (int i = 0; i < cmd.length; i++) {
            char c = cmd[i].charAt(0);
            if (c == 'U') {
                int num = Integer.parseInt(cmd[i].substring(2));
                while (num-- > 0) {
                    k = pre[k];
                }
            } else if (c == 'D') {
                int num = Integer.parseInt(cmd[i].substring(2));
                while (num-- > 0) {
                    k = next[k];
                }
            } else if (c == 'C') {
                stack.push(new Node(pre[k], k, next[k]));
                if (pre[k] != -1) {
                    next[pre[k]] = next[k]; //현재 노드 삭제 후 앞뒤 연결
                }
                if (next[k] != -1) {
                    pre[next[k]] = pre[k];
                }
                sb.setCharAt(k, 'X');

                if (next[k] != -1) {
                    k = next[k];
                } else {
                    k = pre[k]; //마지막 행인 경우에 바로 윗 행 선택
                }
            } else {
                Node node = stack.pop();
                if (node.pre != -1) {
                    next[node.pre] = node.cur; //연결 정보 복구
                }
                if (node.nxt != -1) {
                    pre[node.nxt] = node.cur;
                }
                sb.setCharAt(node.cur, 'O');
            }
        }
        return sb.toString();
    }

}

class Node {

    int pre, cur, nxt;

    public Node(int pre, int cur, int nxt) {
        this.pre = pre;
        this.cur = cur;
        this.nxt = nxt;
    }

}
