package BackJoon.MathematicalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//설탕 배달
//5와 3을 최소 횟수로 합하여 N을 만드는 문제
public class BJ_2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int weightOfSugar = Integer.parseInt(br.readLine());
        if (weightOfSugar < 3 || weightOfSugar > 5000) return;
        int five = 0;
        int three = 0;
        int quotient = weightOfSugar / 5;
        if(weightOfSugar % 5 == 0) { //5로 나누어 떨어는 경우
            System.out.println(quotient);
            return;
        }
        while (quotient > -1){
            if((weightOfSugar - (5 * quotient)) % 3 == 0){ //5킬로그램으로 가져다 줄수 있는 최대 갯수 부터 - 해가며 3으로 가져다 줄수 있는 경우의 수 찾음.
                three = (weightOfSugar - (5 * quotient)) / 3;
                five = quotient;
                System.out.println(five + three);
                return;
            }
            if(quotient == 0) {
                System.out.println(-1);
                return;
            }
            --quotient;
        }
    }
}
