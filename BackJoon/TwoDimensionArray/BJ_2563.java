package BackJoon.TwoDimensionArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int paperCnt = Integer.parseInt(br.readLine());

        int [][] drawingPaper = new int[100][100];
        final int SIDE_LENGTH = 10;
        int area = 0;

        StringTokenizer st;
        for(int i = 0; i < paperCnt; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for(int j = 0; j < SIDE_LENGTH; j++){
                int tempY = y;
                for(int k = 0; k < SIDE_LENGTH; k++){
                    drawingPaper[x-1][(tempY++)-1] = 1;
                }
                x++;
            }
        }
        for(int i = 0; i < drawingPaper.length; i++){
            for(int j = 0; j < drawingPaper[i].length; j++)
                if(drawingPaper[i][j] == 1) area++;
        }
        System.out.println(area);
    }
}
