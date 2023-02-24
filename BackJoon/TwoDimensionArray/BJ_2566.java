package BackJoon.TwoDimensionArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//최댓값을 2차원에서 찾는 문제
public class BJ_2566 {
    public static void main(String[] args) throws IOException {

        int [][] array = new int[9][9];
        int max = 0;
        int row = 1;
        int col = 1;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;// = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < array.length; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < array[i].length; j++){
                int num = Integer.parseInt(st.nextToken());
                if(num >= 100) return;
                array[i][j] = num;
                if(num > max){
                    max = num;
                    row = i + 1;
                    col = j + 1;
                }
            }
        }

        System.out.println(max);
        System.out.println(row + " " + col);
    }
}
