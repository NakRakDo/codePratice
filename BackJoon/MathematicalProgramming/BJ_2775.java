package BackJoon.MathematicalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//부녀회장이 될테야
//층과 거주자 수의 규칙을 찾는 문제
public class BJ_2775 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t > 0) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            if (k < 1 || n > 14) return;

            int[][] apt = new int[k + 1][n]; //아파트 배열 생성 / k+1 (0층 포함) 수만큼 층수 / n 수만큼 호수가 정해짐

            int i = n; // 0층 주민 수 초기화 1 ~ n
            while (i > 0) {
                apt[0][--i] = i + 1;
            }

            //현재 층수에 전 층수들의 합을 넣음. s = storey, n = num
            for (int s = 1; s <= k; s++) {
                int residentsSum = 0; // s-1 층 층수의 총 주민 수 누적 합을 담는 변수
                for (int r = 0; r < n; r++) {
                    residentsSum += apt[s - 1][r]; //s-1 층 r호수의 주민 수를 residentsSum 에누적시키고,
                    apt[s][r] += residentsSum; // s층 r호수에 삽입
                }
            }

            System.out.println(apt[k][n - 1]); //k층 n-1호 (배열은 0부터)가 제출 응답.
            --t;
        }
    }
}
