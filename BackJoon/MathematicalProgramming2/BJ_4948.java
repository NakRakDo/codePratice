package BackJoon.MathematicalProgramming2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//베르트랑 공준
//n 과 2n 사이의 소수 갯수 구하기
public class BJ_4948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int count = 0;
            int n = Integer.parseInt(br.readLine());
            if (n < 1 || n > 123456) return;
            if (n == 0) break;

            outer:
            for (int i = n + 1; i <= 2 * n; i++) {
                int dividend = (int) Math.sqrt(i); // 특정 수가 2개의 수의 곱이라 했을때 둘중하나는 무조건 제곱근보다 작거나 같다.
                while (dividend > 1) {
                    if (i % dividend-- == 0) continue outer;
                }
                if (dividend == 1 && i != 1) ++count;
            }

            if(count == 0) return;
            System.out.println(count);
        }
    }
}
