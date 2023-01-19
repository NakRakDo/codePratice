package BackJoon.MathematicalProgramming;

import java.io.IOException;
import java.util.Scanner;

//벌집
public class BJ_2292 {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt(); //목적지 방 번호
        if(a < 1 || a > 1000000000) return;
        if (a == 1) {
            System.out.println(1);
            return;
        }
        int sumOfMultiples = 0;
        int m = 0;
        while (true) {
            if(sumOfMultiples < (a - 1) && (a - 1) <= (6 * ++m) + sumOfMultiples){
                break;
            }
            sumOfMultiples = (6 * m) + sumOfMultiples;
        }
        System.out.println(m + 1);
    }
}
