package main.java.com.poogle.BOJ.Q11723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = 20;
        int s = 0;
        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            String[] line = br.readLine().split(" ");
            switch (line[0]) {
                //add x: S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
                case "add": {
                    int x = Integer.parseInt(line[1]) - 1;
                    s = (s | 1 << x);
                    break;
                }
                //remove x: S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
                case "remove": {
                    int x = Integer.parseInt(line[1]) - 1;
                    s = (s & ~(1 << x));
                    break;
                }
                //check x: S에 x가 있으면 1을, 없으면 0을 출력한다. (1 ≤ x ≤ 20)
                case "check": {
                    int x = Integer.parseInt(line[1]) - 1;
                    int result = (s & (1 << x));
                    if (result == 0) {
                        sb.append("0\n");
                    } else {
                        sb.append("1\n");
                    }
                    break;
                }
                //toggle x: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
                case "toggle": {
                    int x = Integer.parseInt(line[1]) - 1;
                    s = (s ^ (1 << x));
                    break;
                }
                //all: S를 {1, 2, ..., 20} 으로 바꾼다.
                case "all":
                    s = (1 << n) - 1;
                    break;
                //empty: S를 공집합으로 바꾼다.
                case "empty":
                    s = 0;
                    break;
            }
        }
        System.out.println(sb);
    }
}
