package main.java.com.poogle.PG.Q67257;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    static List<List<String>> priorList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(solution("100-200*300-500+20")); //60420
    }

    private static long solution(String expression) {
        long answer = 0;
        boolean[] visited = new boolean[3];
        String[] operatorTypes = {"-", "+", "*"};
        permutation(new ArrayList<>(), operatorTypes, visited);
        List<Long> nums = Arrays.stream(expression.replaceAll("[^0-9]", ",").split(",")).map(Long::parseLong)
            .collect(Collectors.toList());
        List<String> operators = Arrays.stream(expression.replaceAll("[0-9]", " ").replaceAll(" ", "").split(""))
            .collect(Collectors.toList());
        for (List<String> priors : priorList) {
            answer = Math.max(answer, solve(priors, nums, operators));
        }
        return answer;
    }

    private static long solve(List<String> priors, List<Long> nums, List<String> operators) {
        List<Long> numsC = new ArrayList<>(nums);
        List<String> opsC = new ArrayList<>(operators);

        for (int i = 0; i < priors.size(); i++) {
            String operator = priors.get(i);
            for (int j = 0; j < opsC.size(); j++) {
                if (operator.equals(opsC.get(j))) {
                    long numA = numsC.get(j);
                    long numB = numsC.get(j + 1);
                    long tmp = calculate(numA, numB, operator);

                    numsC.remove(j + 1);
                    numsC.remove(j);
                    opsC.remove(j);
                    numsC.add(j, tmp);
                    j--;
                }
            }
        }
        return Math.abs(numsC.get(0));
    }


    private static void permutation(ArrayList<String> arrayList, String[] orders, boolean[] visited) {
        if (arrayList.size() == 3) {
            priorList.add(arrayList);
            return;
        }
        for (int i = 0; i < orders.length; i++) {
            if (!visited[i]) {
                ArrayList<String> tmp = new ArrayList<>(arrayList);
                tmp.add(orders[i]);
                visited[i] = true;
                permutation(tmp, orders, visited);
                visited[i] = false;
            }
        }
    }

    private static long calculate(long a, long b, String op) {
        long result = 0;
        switch (op) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
        }
        return result;
    }

}
