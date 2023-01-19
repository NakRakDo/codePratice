package BackJoon.MathematicalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

//큰수 A+B
//파이썬 같은 언어는 10,000자리 정도의 자연수도 자유롭게 다룰 수 있습니다.
// 하지만 C/C++이라면 이 문제를 어떻게 풀까요? C/C++ 사용자가 아니더라도 고민해 보면 좋을 것입니다.
public class BJ_10757 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BigInteger bigA = new BigInteger(st.nextToken());
        BigInteger bigB = new BigInteger(st.nextToken());

        if(bigA.compareTo(BigInteger.valueOf(0)) < 0 || bigB.compareTo(BigInteger.valueOf(0)) < 0) return;
        if(bigA.compareTo(BigInteger.valueOf(10).pow(10000)) > 0 || bigB.compareTo(BigInteger.valueOf(10).pow(10000))  > 0) return;

        System.out.println(bigA.add(bigB));
    }
}
