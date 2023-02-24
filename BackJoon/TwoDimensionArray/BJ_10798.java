package BackJoon.TwoDimensionArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//세로 읽기
//문자열의 배열을 다루는 문제
public class BJ_10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char [][] array = new char[5][15];
        for(int i = 0; i < 5; i++){
            String word = br.readLine();
            for(int j = 0; j < word.length(); j++){
                array[i][j] = word.charAt(j);
            }
        }

        StringBuilder sb = new StringBuilder();
        int k = 0;
        while(k < 15){
            for(int i = 0; i < array.length; i++){
                if(array[i][k] == 0) continue;
                sb.append(array[i][k]);
            }
            k++;
        }

        System.out.println(sb);
    }
}
