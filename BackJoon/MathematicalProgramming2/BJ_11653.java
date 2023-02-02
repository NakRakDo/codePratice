package BackJoon.MathematicalProgramming2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//소인수분해
//N을 소인수분해하는 문제
public class BJ_11653 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int divisor = Integer.parseInt(br.readLine());
        int dividend = 2;

        while (divisor != 1) {
            while(divisor % dividend == 0){
                divisor = divisor / dividend;
                System.out.println(dividend);
            }
            ++dividend;
        }
    }
}
