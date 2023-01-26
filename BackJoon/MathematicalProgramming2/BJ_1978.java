package BackJoon.MathematicalProgramming2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//소수 찾기
// 2부터 x-1까지 모두 나눠서 X가 소수인지 확인하는 문제1
public class BJ_1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        if(count < 0 || count > 100) return; // 첫째 줄 숫자 개수 제한
        int answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        while(count > 0){
            int primeNum = Integer.parseInt(st.nextToken());
            if(primeNum < 0 || primeNum > 1000) return; // 첫째 줄 숫자 개수 제한

            int dividend = primeNum;
            while(dividend > 1){
                if(primeNum % (dividend-- - 1) == 0) break; //자기 자신으로 나누지 않아도 되니 피제수에서 -1 하면서 looping
            }

            if(dividend == 1 && primeNum != 1) ++answer; //loop가 끝나고 제수가 1이 아니면서 피제수가 1인경우 소수.
            --count; //개수 --
        }
        System.out.println(answer);
    }
}

// 다른 풀이
// 수학적 특성을 이용하여 주어진 수의 제곱근 그 이상으로만 체크하지 않으면 된다.