package main.java.com.poogle.BOJ.Q7569;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][][] box;
    static int[] dx = new int[]{1, -1, 0, 0, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1, 0, 0};
    static int[] dz = new int[]{0, 0, 0, 0, 1, -1};
    static int m;
    static int n;
    static int h;
    static boolean[][][] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        h = sc.nextInt();
        box = new int[103][103][103];
        check = new boolean[103][103][103];
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    box[i][j][k] = sc.nextInt();
                    if (box[i][j][k] == 1) {
                        queue.add(new Node(i, j, k));
                    }
                }
            }
        }
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < 6; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                int nz = node.z + dz[i];
                if (nx < 0 || nx >= h || ny < 0 || ny >= n || nz < 0 || nz >= m) continue;
                if (box[nx][ny][nz] == 0 && !check[nx][ny][nz]) {
                    queue.offer(new Node(nx, ny, nz));
                    box[nx][ny][nz] = box[node.x][node.y][node.z] + 1;
                    check[nx][ny][nz] = true;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (box[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    answer = Math.max(answer, box[i][j][k]);
                }
            }
        }
        System.out.println(answer - 1);
    }
}

class Node {
    public Node(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    int x, y, z;

}