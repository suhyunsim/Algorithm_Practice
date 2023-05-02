package main.java.com.poogle.BOJ.Q14725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        TrieNode trieNode = new TrieNode();

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            String[] arr = new String[K];
            for (int i = 0; i < K; i++) {
                arr[i] = st.nextToken();
            }
            trieNode.insert(arr);
        }
        trieNode.print(trieNode, 0);
    }

    public static class TrieNode {
        Map<String, TrieNode> childNodes = new HashMap<>();

        public TrieNode() {}

        public void insert(String[] str) {
            TrieNode trieNode = this;
            for (String s : str) {
                trieNode.childNodes.putIfAbsent(s, new TrieNode());
                trieNode = trieNode.childNodes.get(s);
            }
        }

        public void print(TrieNode curr, int depth) {
            TrieNode trieNode = curr;
            if (trieNode.childNodes != null) {
                List<String> list = new ArrayList<>(trieNode.childNodes.keySet());
                Collections.sort(list);

                for (String str : list) {
                    for (int i = 0; i < depth; i++) {
                        System.out.print("--");
                    }
                    System.out.println(str);
                    print(trieNode.childNodes.get(str), depth + 1);
                }
            }
        }
    }
}
