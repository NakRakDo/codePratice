package BackJoon.MathematicalProgramming2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//소수구하기
//더 빠르게 소수를 판별하는 문제
public class BJ_1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        if(m < 1 || m > 1000000) return;
        if(n < 1 || n > 1000000) return;
        outer :for(int i = m; i <= n; i++){
            int dividend = (int) Math.sqrt(i); // 특정 수가 2개의 수의 곱이라 했을때 둘중하나는 무조건 제곱근보다 작거나 같다.
            while(dividend > 1){
                if(i % dividend-- == 0) continue outer;
            }
            if(dividend == 1 && i != 1) System.out.println(i);
        }
    }
}
