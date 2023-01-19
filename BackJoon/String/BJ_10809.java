package BackJoon.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
//알파벳 찾기
public class BJ_10809 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String givenWord = "";
        givenWord = br.readLine();

        int[] firstIndexArr = new int[26];
        Arrays.fill(firstIndexArr, -1);

        int index = 0;

        while(index != givenWord.length()){
            char ch = givenWord.charAt(index);
            int pos = givenWord.indexOf(ch);
            if (firstIndexArr[ch - 97] == -1) firstIndexArr[ch - 97] = pos;
            ++index;
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(firstIndexArr[0]);
        for(int i = 1; i < firstIndexArr.length; ++i) {
            stringBuilder.append(" " + firstIndexArr[i]);
        }

        System.out.println(stringBuilder.toString());

    }
}
