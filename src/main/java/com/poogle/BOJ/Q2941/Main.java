package main.java.com.poogle.BOJ.Q2941;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        int cnt = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == 'c') {
                if (i < word.length() - 1) {
                    if (word.charAt(i + 1) == '=' || word.charAt(i + 1) == '-') {
                        i++;
                    }
                }
            } else if (c == 'd') {
                if (i < word.length() - 1) {
                    if (word.charAt(i + 1) == 'z') {
                        if (i < word.length() - 2) {
                            if (word.charAt(i + 2) == '=') {
                                i+=2;
                            }
                        }
                    } else if (word.charAt(i + 1) == '-') {
                        i++;
                    }
                }
            } else if (c == 'n' || c == 'l') {
                if (i < word.length() - 1) {
                    if (word.charAt(i + 1) == 'j') {
                        i++;
                    }
                }
            } else if (c == 's' || c == 'z') {
                if (i < word.length() - 1) {
                    if (word.charAt(i + 1) == '=') {
                        i++;
                    }
                }
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}
