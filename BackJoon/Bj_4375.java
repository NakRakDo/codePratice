package BackJoon;

import java.util.Scanner;

//2와 5로 나누어떨어지지 않는 수중에 1로만 이루어진 수를 찾아라
public class Bj_4375 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()){
            int num = scanner.nextInt(); //~~BufferedReader를 사용하려 했으나..~~
            System.out.println(One(num));
        }
    }
    public static int One(int num) {
        int x = 1;
        for(int i=1; ; i++) {
            x = x % num;
            x = x * 10 +1;
            if( x == 1) {
                return i;
            }
        }
    }

}
