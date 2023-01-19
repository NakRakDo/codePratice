package BackJoon.MathematicalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//ACM 호텔
//호텔 방 번호의 규칙을 찾아 출력하는 문제
public class BJ_10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfTestCase = Integer.parseInt(br.readLine());

        while (0 < numOfTestCase) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int height = Integer.parseInt(st.nextToken());
            int width = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if(height < 1) return;;
            if(width > 99) return;
            if(num < 1 || num > height * width) return;

            int roomNum = getAssignedRoomNumber(height,width,num);
            System.out.println(roomNum);
            numOfTestCase--;
        }
    }

    public static int getAssignedRoomNumber(int height, int width, int num) {
        if(num  == 1) return 101;

        //층수별로 나머지와 몫이 동일하도록 계산하기 쉽게 N-1 로 계산
        int line = ((num - 1) / height) + 1; //라인은 N번째 손님을 height로 나눈 몫
        int storey = (((num - 1) % height) + 1)  * 100; //층수는 N번째 손님을 height로 나눈 나머지로 계산

        return line + storey;
    }
}
