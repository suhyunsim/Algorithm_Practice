package main.java.com.poogle.PG.Q43163;

public class Solution {
    static int answer;
    static boolean[] visited;

    public static void main(String[] args) {
        System.out.println(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
        System.out.println(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}));
    }

    public static int solution(String begin, String target, String[] words) {
        answer = 51;
        visited = new boolean[51];
        dfs(begin, target, words, 0);
        return answer == 51 ? 0 : answer;
    }

    private static void dfs(String begin, String target, String[] words, int cnt) {
        if (begin.equals(target)) {
            answer = Math.min(answer, cnt);
            return;
        }
        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && check(begin, words[i])) {
                visited[i] = true;
                dfs(words[i], target, words, cnt + 1);
                visited[i] = false;
            }
        }
    }

    private static boolean check(String begin, String word) {
        int cnt = 0;
        for (int j = 0; j < begin.length(); j++) {
            if (begin.charAt(j) != word.charAt(j)) cnt++;
        }
        return cnt == 1;
    }
}
