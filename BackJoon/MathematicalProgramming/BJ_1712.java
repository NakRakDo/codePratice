package BackJoon.MathematicalProgramming;

import java.io.IOException;
import java.util.Scanner;

public class BJ_1712 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt(); //고정
        int b = scanner.nextInt(); //가변
        int c = scanner.nextInt(); //노트북 판매가

        if(c-b <= 0) {System.out.println(-1); return;}

        int d = (a/(c-b)) + 1 ; //손익분기점 판매대수
        //a 고정비용, b 가변 비용, c 노트북 판매가, d 판매 수량
        System.out.println(d);
    }
}
