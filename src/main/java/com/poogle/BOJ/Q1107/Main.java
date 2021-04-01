package main.java.com.poogle.BOJ.Q1107;

import java.util.Scanner;

public class Main {
    static boolean[] broken = new boolean[10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        //고장난 채널 표시
        while (m-- > 0) {
            int x = sc.nextInt();
            broken[x] = true;
        }
        //정답의 초기값 표시: 숫자 버튼을 안 누름
        int ans = n - 100;
        if (ans < 0) {
            ans = -ans;
        }
        //이동의 초기값
        for (int i = 0; i <= 1000000; i++) {
            int c = i;
            //이동여부 판단
            int len = possible(c);
            /*
            100에서 c로 숫자 이동(len)
            c에서 n으로 +/-로 이동(press)
            둘을 더한 값과 초기값을 비교해서 더 작은 값을 고르도록
            */
            if (len > 0) {
                int press = c - n;
                if (press < 0) {
                    press = -press;
                }
                if (ans > len + press) {
                    ans = len + press;
                }
            }
        }
        System.out.println(ans);
    }

    //채널 c로 이동 가능하면 1, 아니면 0
    private static int possible(int c) {
        if (c == 0) {
            //0이 고장나면 이동할수 없음
            if (broken[0]) {
                return 0;
            } else {
                return 1;
            }
        }
        int len = 0;
        while (c > 0) {
            //고장났으면 true -> 0 리턴
            if (broken[c % 10]) {
                return 0;
            }
            len += 1;
            c /= 10;
        }
        return len;
    }
}
