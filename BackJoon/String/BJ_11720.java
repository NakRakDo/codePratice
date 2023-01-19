package BackJoon.String;

//숫자의 합
public class BJ_11720 {
    public int sumOfNumbers(String length, String numbers) {
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기

        int len = Integer.parseInt(length) - 1;
        int resultSum = 0;

        if(len < 1 || len > 100) return -1;

        while(len != -1){
            resultSum += numbers.charAt(len) - 48;
            len--;
        }

        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime);
        System.out.println("시간차이(m) : "+secDiffTime);

        Runtime.getRuntime().gc();
        long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("This code used " +usedMemory/1000 + " KBytes");

        return resultSum;
    }
}

/* 제출용
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String length = "";
        String number = "";
        length = br.readLine();
        number = br.readLine();

        int len = Integer.parseInt(length) - 1;
        int resultSum = 0;

        if(len < 1 || len > 100) return;
        while(len != -1){
            resultSum += Character.getNumericValue(number.charAt(len));
            --len;
        }
        System.out.println(resultSum);
    }
}
* 
*/
