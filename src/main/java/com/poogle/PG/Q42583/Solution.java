package main.java.com.poogle.PG.Q42583;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(2, 10, new int[]{7, 4, 5, 6}));
    }

    private static int solution(int bridge_length, int weight, int[] truck_weights) {
        //다리 자체
        Queue<Integer> queue = new LinkedList<>();
        //걸리는 시간
        int answer = 0;
        //다리 위 총 무게
        int sum = 0;
        for (int t : truck_weights) {
            while (true) {
                if (queue.isEmpty()) {
                    queue.add(t);
                    sum += t;
                    answer++;
                    break;
                //다리가 꽉 찼다면
                } else if (queue.size() == bridge_length) {
                    sum -= queue.poll();
                //다리는 꽉 차지 않았을 때
                } else {
                    //새로 진입할 트럭의 무게가 다리가 버틸 무게를 초과하는 경우
                    if (sum + t > weight) {
                        queue.add(0);
                        answer++;
                    } else {
                        queue.add(t);
                        sum += t;
                        answer++;
                        break;
                    }
                }
            }
        }
        //모두 지나갈 수 있도록
        return answer + bridge_length;
    }
}
