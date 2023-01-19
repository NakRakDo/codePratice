package BackJoon;

import BackJoon.String.BJ_11720;

import java.io.IOException;

public class aMainTest {
    public static void main(String[] args) throws IOException {

        BJ_11720 bj11720 = new BJ_11720();
        System.out.println(bj11720.sumOfNumbers("7","1234567"));
        System.out.println(bj11720.sumOfNumbers("3","137"));
        System.out.println(bj11720.sumOfNumbers("5","54321"));
        System.out.println(bj11720.sumOfNumbers("11","10987654321"));
        System.out.println(bj11720.sumOfNumbers("25","7000000000000000000000000"));
    }
}
