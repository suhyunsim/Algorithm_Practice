package main.java.com.poogle.BOJ.Q1620;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = stringToInteger(st.nextToken());
        int M = stringToInteger(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        String[] pokemons = new String[N];
        for (int i = 0; i < N; i++) {
            String pokemon = br.readLine();
            map.put(pokemon, i + 1);
            pokemons[i] = pokemon;
        }
        while (M-- > 0) {
            String question = br.readLine();
            if (question.charAt(0) <= 57) {
                int key = stringToInteger(question);
                sb.append(pokemons[key - 1]);
            } else {
                sb.append(map.get(question));
            }
            sb.append("\n");
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }

    public static int stringToInteger(String s) {
        return Integer.parseInt(s);
    }
}
