package main.java.com.poogle.BOJ.Q6593;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int l, r, c;
    static char[][][] building;
    static int[][][] distance;
    static int[] dx = new int[]{1, -1, 0, 0, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1, 0, 0};
    static int[] dz = new int[]{0, 0, 0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            l = sc.nextInt();
            r = sc.nextInt();
            c = sc.nextInt();
            if (l == 0 && r == 0 && c == 0) {
                break;
            }
            Queue<Node> queue = new LinkedList<>();
            building = new char[l][r][c];
            distance = new int[l][r][c];
            boolean exit = false;

            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    for (int k = 0; k < c; k++) {
                        distance[i][j][k] = 0;
                    }
                }
            }

            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    String row = sc.next();
                    for (int k = 0; k < c; k++) {
                        building[i][j][k] = row.charAt(k);
                        if (building[i][j][k] == 'S') {
                            queue.add(new Node(i, j, k));
                            distance[i][j][k] = 0;
                        } else if (building[i][j][k] == '.') {
                            distance[i][j][k] = -1;
                        }
                    }
                }
            }

            while (!queue.isEmpty()) {
                if (exit) break;
                Node node = queue.poll();

                for (int i = 0; i < 6; i++) {
                    int nx = node.x + dx[i];
                    int ny = node.y + dy[i];
                    int nz = node.z + dz[i];
                    if (nx < 0 || nx >= r || ny < 0 || ny >= c || nz < 0 || nz >= l) continue;
                    if (building[nz][nx][ny] == '#' || distance[nz][nx][ny] > 0) continue;
                    distance[nz][nx][ny] = distance[node.z][node.x][node.y] + 1;
                    if (building[nz][nx][ny] == 'E') {
                        System.out.println("Escaped in " + distance[nz][nx][ny] + " minute(s).");
                        exit = true;
                        break;
                    }
                    queue.offer(new Node(nz, nx, ny));
                }
            }
            while (!queue.isEmpty()) queue.poll();
            if (!exit) System.out.println("Trapped!");
        }
    }
}

class Node {
    int x, y, z;

    public Node(int z, int x, int y) {
        this.z = z;
        this.x = x;
        this.y = y;
    }
}