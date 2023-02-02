package BackJoon.MathematicalProgramming2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//골드바흐의 추축
//2보다 큰 모든 짝수는 2개의 소수의 합으로 나타낼수 있따.
public class BJ_9020 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for(int i = 1; i <= testCase; i++){
            int target = Integer.parseInt(br.readLine());
            if(target < 4 || target > 10000) return;

            int primeNum1 = 0;
            int primeNum2 = 0;

            int minus = 2;
            int minPrimeGap = target; // 대상 수는 자기를 구성하는 소수보다 크니까. minPrimeGap = Math.min(a - b, minPrimeGap) 구분에서 항상 0이되는걸 방지.
            while(true){
                int a = target - minus;
                int b = minus++;

                if(a < b) { // 조건1:대상 수의 절반 부터는 소수 차이를 판별하는 두수가 위치만 바뀌고 그 결과값이 기존에 계산됬던 값의 음수값 이므로
                    System.out.println(primeNum2 + " " + primeNum1); // 대상수 크기의 반만큼 진행하도록 함
                    break;
                }
                if(!(isPrimeNum(a) && isPrimeNum(b))) continue; //조건2 : 소수간의 차이니 둘중 하나라도 소수가 아니면 continue;

                primeNum1 = a;
                primeNum2 = b;
                minPrimeGap = Math.min(a - b, minPrimeGap);
            }
        }
    }
    public static boolean isPrimeNum(int divisor){
        int dividend = (int)Math.sqrt(divisor);
        while (dividend > 1) {
            if(divisor % dividend-- == 0) return false; //딱 떨어지면 소수가 아니다.
        }
        return divisor != 1 && dividend == 1;
    }
}
