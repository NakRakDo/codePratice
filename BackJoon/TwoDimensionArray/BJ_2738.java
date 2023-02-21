package BackJoon.TwoDimensionArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//행렬 덧셈
//행렬을 2차원 배열로 만들어 더하는 문제
public class BJ_2738 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int rowLen = Integer.parseInt(st.nextToken());
        int colLen = Integer.parseInt(st.nextToken());

        if(rowLen > 100 && colLen > 100) return;

        int [][] array = new int[rowLen][colLen];

        for(int i = 0; i < rowLen; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0; j < colLen; j++){
                int element = Integer.parseInt(st.nextToken());
                if(Math.abs(element) > 100) return;
                array[i][j] = element;
            }
        }

        for(int i = 0; i < rowLen; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0; j < colLen; j++){
                int element = Integer.parseInt(st.nextToken());
                if(Math.abs(element) > 100) return;
                array[i][j] += element;
            }
        }


        for(int i = 0; i < rowLen; i++){
            for(int j = 0; j < colLen; j++){
                if(j == colLen - 1){
                    System.out.println(array[i][j]);
                    continue;
                };
                System.out.print(array[i][j] + " ");
            }
        }
    }
}
