package main.java.com.poogle.BOJ.Q15681;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] childArr;
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }
        childArr = new int[n + 1];
        Arrays.fill(childArr, 1);

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(v);
            list[v].add(u);
        }

        makeTree(r, -1);
        for (int i = 0; i < q; i++) {
            int index = Integer.parseInt(br.readLine());
            System.out.println(childArr[index]);
        }
    }

    private static void makeTree(int currentNode, int parentNode) {
        for (int next : list[currentNode]) {
            if (parentNode != next) {
                makeTree(next, currentNode);
            }
        }
        if (parentNode != -1) {
            childArr[parentNode] += childArr[currentNode];
        }
    }
}
