package main.java.com.poogle.BOJ.Q14891;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 4;
        char[][] arr = new char[4][8];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next().toCharArray();
        }
        int k = sc.nextInt();
        while (k-- > 0) {
            //회전시킨 톱니 번호
            int no = sc.nextInt() - 1;
            //방향(1: 시계 / -1: 반시계)
            int dir = sc.nextInt();
            //각 톱니가 어떤 방향으로 회전하는지
            int[] d = new int[n];
            d[no] = dir;

            //조사하기
            //왼
            for (int i = no - 1; i >= 0; i--) {
                //다른극
                if (arr[i][2] != arr[i + 1][6]) {
                    d[i] = -d[i + 1];
                } else {
                    break;
                }
            }

            //오
            for (int i = no + 1; i < n; i++) {
                //다른극
                if (arr[i - 1][2] != arr[i][6]) {
                    d[i] = -d[i - 1];
                } else {
                    break;
                }
            }

            //회전하기
            for (int i = 0; i < n; i++) {
                if (d[i] == 0) continue;
                if (d[i] == 1) {
                    //시계방향
                    char temp = arr[i][7];
                    for (int j = 7; j >= 1; j--) {
                        arr[i][j] = arr[i][j - 1];
                    }
                    arr[i][0] = temp;
                } else if (d[i] == -1) {
                    //반시계방향
                    char temp = arr[i][0];
                    for (int j = 0; j < 7; j++) {
                        arr[i][j] = arr[i][j + 1];
                    }
                    arr[i][7] = temp;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i][0] == '1') {
                ans |= (1 << i);
            }
        }
        System.out.println(ans);
    }
}
