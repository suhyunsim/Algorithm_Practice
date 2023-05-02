package main.java.com.poogle.BOJ.Q7432;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        TrieNode trieNode = new TrieNode();
        for (int i = 0; i < N; i++) {
            trieNode.insert(br.readLine());
        }
        trieNode.print(trieNode, 0);
    }

    public static class TrieNode {
        Map<String, TrieNode> childNodes = new HashMap<>();

        public TrieNode() {}

        public void insert(String str) {
            TrieNode trieNode = this;
            String[] strs = str.split("\\\\");
            for (String s : strs) {
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
                        System.out.print(" ");
                    }
                    System.out.println(str);
                    print(trieNode.childNodes.get(str), depth + 1);
                }
            }
        }
    }

}

