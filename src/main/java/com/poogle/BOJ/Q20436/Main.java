package main.java.com.poogle.BOJ.Q20436;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static Map<String, Node> leftKeyBoard = new HashMap<>();
    static Map<String, Node> rightKeyBoard = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String left = st.nextToken();
        String right = st.nextToken();
        String word = br.readLine();
        initializeKeyBoard();

        int result = 0;
        for (int i = 0; i < word.length(); i++) {
            String c = word.charAt(i) + "";
            if (leftKeyBoard.containsKey(c)) {
                Node before = leftKeyBoard.get(left);
                Node after = leftKeyBoard.get(c);
                result += (Math.abs(before.x - after.x) + Math.abs(before.y - after.y));
                left = c;
            } else {
                Node before = rightKeyBoard.get(right);
                Node after = rightKeyBoard.get(c);
                result += (Math.abs(before.x - after.x) + Math.abs(before.y - after.y));
                right = c;
            }
            result++;
        }
        System.out.println(result);
    }

    private static void initializeKeyBoard() {

        leftKeyBoard.put("q", new Node(0, 0));
        leftKeyBoard.put("w", new Node(1, 0));
        leftKeyBoard.put("e", new Node(2, 0));
        leftKeyBoard.put("r", new Node(3, 0));
        leftKeyBoard.put("t", new Node(4, 0));

        rightKeyBoard.put("y", new Node(5, 0));
        rightKeyBoard.put("u", new Node(6, 0));
        rightKeyBoard.put("i", new Node(7, 0));
        rightKeyBoard.put("o", new Node(8, 0));
        rightKeyBoard.put("p", new Node(9, 0));

        leftKeyBoard.put("a", new Node(0, 1));
        leftKeyBoard.put("s", new Node(1, 1));
        leftKeyBoard.put("d", new Node(2, 1));
        leftKeyBoard.put("f", new Node(3, 1));
        leftKeyBoard.put("g", new Node(4, 1));

        rightKeyBoard.put("h", new Node(5, 1));
        rightKeyBoard.put("j", new Node(6, 1));
        rightKeyBoard.put("k", new Node(7, 1));
        rightKeyBoard.put("l", new Node(8, 1));

        leftKeyBoard.put("z", new Node(0, 2));
        leftKeyBoard.put("x", new Node(1, 2));
        leftKeyBoard.put("c", new Node(2, 2));
        leftKeyBoard.put("v", new Node(3, 2));

        rightKeyBoard.put("b", new Node(4, 2));
        rightKeyBoard.put("n", new Node(5, 2));
        rightKeyBoard.put("m", new Node(6, 2));

    }
}

class Node {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
