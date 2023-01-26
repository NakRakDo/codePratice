package BackJoon.MathematicalProgramming2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//소수
//2부터 X-1까지 모두 나눠서 X가 소수인지 판별하는 문제 2
public class BJ_2581 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        if(m < 0 || m > 10000) return; // 숫자 제한
        if(n < 0 || n > 10000) return; // 숫자 제한

        int primeSum = 0; //소수합
        int minPrimeNUm = -1;//최소값 소수

        outer : for(int i = m; i <= n; i++){
            int dividend = (int)Math.sqrt(i); // 제곱근 이상인 경우는 어차피 제곱근 이하인 수들에 대해 배수및 약수로 되기때문.

            while(dividend > 1){
                if(i % dividend-- == 0) continue outer; // 제수를 피제수로 나누면서 나머지 체크
            }

            if(dividend == 1 && i != 1) { //1까지 나누게된 수 및 제수가 1이아닌수
                if(minPrimeNUm == -1) minPrimeNUm = i; // 최소 소수가 할당되지 않았따면 할당
                primeSum += i; // 합계 누적
            }
        }
        if(minPrimeNUm == -1) {
            System.out.println(-1);
            return;
        }
        System.out.println(primeSum);
        System.out.println(minPrimeNUm);

    }
}
