package main.java.com.poogle.BOJ.Q13300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int room = 0;
        // 1 ~ 6학년 , 남 & 여 구분
        int[][] student = new int[7][2];

        // 각 학년별 남학생, 여학생 구분해서 카운트
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());    // 성별
            int b = Integer.parseInt(st.nextToken());    // 학년
            if (a == 0) student[b][0]++;    // 여성 => [학년][0] ++
            else student[b][1]++;       // 남성 => [학년][1] ++
        }

        for (int i = 1; i < student.length; i++) {
            for (int j = 0; j < student[i].length; j++) {
                if (student[i][j] == 0) continue;    // i학년 학생이 없는 경우 => 방 필요없이 통과
                room += student[i][j] / K;    // 필요한 방 계산
                if (student[i][j] % K != 0)    // 방이 학생에 나누어 떨어지지 않으면 방 하나 더 필요
                    room += 1;
            }
        }
        System.out.println(room);
        bf.close();
    }

}
