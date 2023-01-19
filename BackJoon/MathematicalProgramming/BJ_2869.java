package BackJoon.MathematicalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//달팽이는 올라가고 싶다
public class BJ_2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int up = Integer.parseInt(st.nextToken());
        int down = Integer.parseInt(st.nextToken());
        int totalHeight = Integer.parseInt(st.nextToken());

        if (0 > down) return;
        if (down >= up) return;
        if (up > totalHeight) return;

        double denominator = totalHeight - up;
        double numerator = up - down;
        double finalMovingDay = Math.ceil(denominator / numerator) + 1;

        System.out.println((int) finalMovingDay);

    }
}
    /*본문 내용도 색다른 풀이 방법이네요 하나 배워갑니다 ㅎㅎ
저의 풀이 법도 공유 하면 도움되실 수 도 있을거같아 공유 드립니다.
공식을 한번 직접 도출해봤는데요.
n이 구하고자 하는 필요한 일 수 입니다.
up + (up - down)n > totalHeight  -> 마지막날 올라가는 높이 + 하루에 올라가는 높이 x 일수(n) > 총 높이
(up - down)n > totalHeight - up
(up - down)n > totalHeight - up
n > (totalHeight - up) / (up - down)

본문에 up : 3,  down : 1,   height : 7 로 예를 들면
3 + (3-1)n > 7
(3-1)n > 7 - 3
2n > 4
n > 2
즉 올라가야 하는 일수는 2일 보다 무조건 커야되니,
그 다음날 올라가는일 수 + 1 해주면 됩니다.

그리고, 문제 선행 조건에 up은 down 보다 작거나 같을 수 없다라는 조건이 있기에,
(totalHeight - up)/(up - down) 나눗셈에서 소숫 자리는 어차피 이동한 날을 의미하게 되서
올림처리하면 됩니다.

따라서 이 방법은 조건문 안 걸어도 되더라구요.

*/

