package BackJoon.MathematicalProgramming;

import java.util.Scanner;

// 분수 찾기
public class BJ_1193 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ip = scanner.nextInt();

        int i = 1;
        int denominator = 1;
        int numerator = 1;
        if(ip == 1) {
            System.out.println(String.valueOf(numerator) + "/" + String.valueOf(denominator));
            return;
        }

        // 등차수열 공식
        // 첫항 마지막항 알때 n(a+l) / 2
        // 첫항, 공차 알때 n{2a + (n-1)}d} / 2
        while (true) {
            int prev = (i * (i + 1)) / 2;               // 단계별 등차수열.
            int next = ((i + 1) * ((i + 1) + 1)) / 2;   // 단계별 등차수열.

            if (prev < ip && ip <= next) {
                if(i % 2 == 0){
                    numerator = next - ip + 1;
                    denominator = ip - prev;
                } else {
                    denominator = next - ip + 1;
                    numerator = ip - prev;
                }
                break;
            }
            i++;
        }
        System.out.println(String.valueOf(numerator) + "/" + String.valueOf(denominator));
    }

}

