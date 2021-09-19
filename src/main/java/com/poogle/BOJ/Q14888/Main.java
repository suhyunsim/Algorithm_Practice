package main.java.com.poogle.BOJ.Q14888;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int plus = sc.nextInt();
        int minus = sc.nextInt();
        int multiply = sc.nextInt();
        int divide = sc.nextInt();

        Pair ans = calc(a, 1, a[0], plus, minus, multiply, divide);
        System.out.println(ans.max);
        System.out.println(ans.min);
    }

    private static Pair calc(int[] a, int index, int cur, int plus, int minus, int multiply, int divide) {
        int n = a.length;
        if (index == n) {
            //정답을 찾은 경우
            return new Pair(cur, cur);
        }
        ArrayList<Pair> result = new ArrayList<>();
        if (plus > 0) {
            result.add(calc(a, index + 1, cur + a[index], plus - 1, minus, multiply, divide));
        }
        if (minus > 0) {
            result.add(calc(a, index + 1, cur - a[index], plus, minus - 1, multiply, divide));
        }
        if (multiply > 0) {
            result.add(calc(a, index + 1, cur * a[index], plus, minus, multiply - 1, divide));
        }
        if (divide > 0) {
            result.add(calc(a, index + 1, cur / a[index], plus, minus, multiply, divide - 1));
        }
        Pair answer = result.get(0);
        for (Pair p : result) {
            if (answer.max < p.max) {
                answer.max = p.max;
            }
            if (answer.min > p.min) {
                answer.min = p.min;
            }
        }
        return answer;
    }
}

class Pair {
    int min, max;

    public Pair(int min, int max) {
        this.min = min;
        this.max = max;
    }
}
