package main.java.com.poogle.PG.Q17862;

public class Solution {
    public static int solution(String dartResult) {
        int[] answer = new int[3];
        int idx = 0;
        int cnt = 0;
        for (int i = 0; i < dartResult.length(); i++) {
            char status = dartResult.charAt(i);
            int dart = Character.getNumericValue(status);
            if (dart >= 0 && dart <= 10) {
                if (dart == 1) {
                    if (Character.getNumericValue(dartResult.charAt(i + 1)) == 0) { //숫자가 10일 때
                        dart = 10;
                        i++;
                    }
                }
                answer[idx] = dart;
                cnt++;
            } else {
                switch (status) {
                    case 'S':
                        answer[idx] = (int) Math.pow(answer[idx], 1);
                        idx++;
                        break;
                    case 'D':
                        answer[idx] = (int) Math.pow(answer[idx], 2);
                        idx++;
                        break;
                    case 'T':
                        answer[idx] = (int) Math.pow(answer[idx], 3);
                        idx++;
                        break;
                    case '*':
                        idx = idx - 2 < 0 ? 0 : idx - 2; //맨 앞일 때 0
                        while (idx < cnt) { //가장 최근 2개의 점수에 2 곱하기
                            answer[idx] = answer[idx] * 2;
                            idx++;
                        }
                        break;
                    case '#':
                        answer[idx - 1] = answer[idx - 1] * (-1);
                        break;
                }
            }
        }
        return answer[0] + answer[1] + answer[2];
    }

    public static void main(String[] args) {
        System.out.println(solution("1S2D*3T"));
        System.out.println(solution("1D2S#10S"));
    }
}
