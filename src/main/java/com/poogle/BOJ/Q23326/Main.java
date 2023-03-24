package main.java.com.poogle.BOJ.Q23326;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int[] A = new int[N + 1];
        // 명소 set
        Set<Integer> spots = new TreeSet<>();
        //현재 위치 기록(시작: 1)
        int now = 1;
        st = new StringTokenizer(br.readLine());
        // 명소 배열, set에 입력
        for (int i = 0; i < N; i++) {
            if (Integer.parseInt(st.nextToken()) == 1) {
                spots.add(i + 1);
                A[i] = 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            String[] query = br.readLine().split(" ");
            // 3번 쿼리: 명소 없으면 -1, 있으면 시계방향으로 최소 몇 칸 움직여야 하는지 출력
            if (query[0].equals("3")) {
                if (spots.isEmpty()) {
                    sb.append("-1");
                    break;
                }
                // lowerBound -> 현재 위치에 가장 가까운 명소의 spotList에서의 인덱스 찾기
                List<Integer> spotList = new ArrayList<>(spots);
                int nextSpotIndex = lowerBound(spotList, now);
                // 다음 명소의 위치가 현재 위치보다 뒤에 있는 경우, 정렬된 spotList에서 첫번째 명소까지의 거리를 구함
                if (now > spotList.get(nextSpotIndex)) {
                    int step = (N - now) + spotList.get(0);
                    sb.append(step).append("\n");
                // 다음 명소의 위치가 현재 위치보다 앞에 있는 경우, 거리를 구함
                } else {
                    sb.append(spotList.get(nextSpotIndex) - now).append("\n");
                }
            // 1번 쿼리: 명소였으면 아닌걸로, 아니었으면 명소로 지정
            } else if (query[0].equals("1")) {
                int qPosition = Integer.parseInt(query[1]);
                if (A[qPosition - 1] == 1) {
                    A[qPosition - 1] = 0;
                    spots.remove(qPosition);
                } else {
                    A[qPosition - 1] = 1;
                    spots.add(qPosition);
                }
            // 2번 쿼리: 시계방향으로 x만큼 이동
            } else {
                int qPlus = Integer.parseInt(query[1]);
                now = (now + qPlus) % N;
                if (now == 0)
                    now = N;
            }
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }

    // spotList에서의 nextSpot 인덱스를 반환
    private static int lowerBound(List<Integer> spots, int target) {
        int left = 0;
        int right = spots.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (spots.get(mid) >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}
