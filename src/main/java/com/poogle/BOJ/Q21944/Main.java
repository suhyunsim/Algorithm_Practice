package main.java.com.poogle.BOJ.Q21944;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    static Map<Integer, TreeSet<Problem>> problemMapByGroup = new HashMap<>();
    static Map<Integer, Integer> levelMap = new HashMap<>();
    static Map<Integer, Integer> groupMap = new HashMap<>();
    static TreeSet<Problem> totalSet = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());
            addProblem(P, L, G);
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "add": {
                    int P = Integer.parseInt(st.nextToken());
                    int L = Integer.parseInt(st.nextToken());
                    int G = Integer.parseInt(st.nextToken());
                    addProblem(P, L, G);
                    break;
                }
                case "recommend": {
                    int G = Integer.parseInt(st.nextToken());
                    int x = Integer.parseInt(st.nextToken());
                    if (x == 1) {
                        System.out.println(problemMapByGroup.get(G).last().number);
                    } else {
                        System.out.println(problemMapByGroup.get(G).first().number);
                    }
                    break;
                }
                case "recommend2": {
                    int x = Integer.parseInt(st.nextToken());
                    if (x == 1) {
                        System.out.println(totalSet.last().number);
                    } else {
                        System.out.println(totalSet.first().number);
                    }
                    break;
                }
                case "recommend3": {
                    int x = Integer.parseInt(st.nextToken());
                    int L = Integer.parseInt(st.nextToken());
                    if (x == 1) {
                        if (totalSet.ceiling(new Problem(0, L, 0)) == null) {
                            System.out.println(-1);
                        } else {
                            System.out.println(totalSet.ceiling(new Problem(0, L, 0)).number);
                        }
                    } else {
                        if (totalSet.floor(new Problem(0, L, 0)) == null) {
                            System.out.println(-1);
                        } else {
                            System.out.println(totalSet.floor(new Problem(0, L, 0)).number);
                        }
                    }
                    break;
                }
                default: {
                    int P = Integer.parseInt(st.nextToken());
                    int L = levelMap.get(P);
                    int G = groupMap.get(P);
                    totalSet.remove(new Problem(P, L, G));
                    problemMapByGroup.get(G).remove(new Problem(P, L, G));
                    levelMap.remove(P);
                    groupMap.remove(P);
                    break;
                }
            }
        }
    }

    private static void addProblem(int P, int L, int G) {
        totalSet.add(new Problem(P, L, G));
        if (problemMapByGroup.containsKey(G)) {
            TreeSet<Problem> problems = problemMapByGroup.get(G);
            problems.add(new Problem(P, L, G));
            problemMapByGroup.replace(G, problems);
        } else {
            TreeSet<Problem> treeSet = new TreeSet<>();
            treeSet.add(new Problem(P, L, G));
            problemMapByGroup.put(G, treeSet);
        }
        levelMap.put(P, L);
        groupMap.put(P, G);
    }
}

class Problem implements Comparable<Problem> {
    int number, level, group;

    public Problem(int number, int level, int group) {
        this.number = number;
        this.level = level;
        this.group = group;
    }

    @Override
    public int compareTo(Problem o) {
        if (this.level - o.level == 0) {
            return this.number - o.number;
        } else {
            return this.level - o.level;
        }
    }
}
