package Programmers.Lvl1;

//level1 바탕화면 정리
public class Clean_Up_the_WallPaper {
    public int[] solution(String[] wallpaper) {
        int[] verticalPoint = getVerticalPoint(wallpaper);
        int[] horizontalPoint = getHorizontalPoint(wallpaper);
        int[] answer = {verticalPoint[0],horizontalPoint[0],verticalPoint[1],horizontalPoint[1]};
        return answer;
    }

    private int[] getVerticalPoint(String[] wallpaper) { //주어진 스르링(wallpaper) 배열의 수직부분의 최소 위치를 구한다.
        int[] verticalPoint = new int [2];
        int cnt = 0;
        for(int i = 0; i < wallpaper.length; i++){//wallpaper의 각행을 가져와 각행에 대해서 파일의 최소위치와 최대 위치를 구함.
            if(wallpaper[i].contains("#")){ //파일이 존재하면
                if(cnt == 0) {//파일이 최초인경우
                    verticalPoint[0] = i; //최소값
                    verticalPoint[1] = i+1; //최대값
                    cnt++;
                    continue;
                }
                verticalPoint[1] = i+1;
                cnt++;
            }

        }
        return verticalPoint;
    }
    private int[] getHorizontalPoint(String[] wallpaper) { //주어진 스르링(wallpaper) 배열의 수평부분의 최소 위치를 구한다.
        int[] horizontalPoint = new int [] {51,0}; //51-> 제한 조건이 51이고,수평부분의 길이는 51보다 클수없으며, 0으로 시작하면 무조건 0으로 고정되기때문에
        for(int i = 0; i < wallpaper.length; i++){//wallpaper의 각원소를 배열로 가져와 각행에 대해서 파일의 최소위치와 최대 위치를 구함.
            char[] row = wallpaper[i].toCharArray();
            int cnt = 0;//파일이 최초로 등장했을경우를 따지기 위함.
            for(int j = 0; j < row.length; j++){
                if(row[j] == '#'){//파일이 존재한다면
                    if(cnt == 0){//파일이최초인경우
                        horizontalPoint[0] = Math.min(horizontalPoint[0],j);//수평의 최소부분을 구함
                        horizontalPoint[1] = Math.max(horizontalPoint[1],j + 1);//수평의 최대부분을 구함
                        cnt++;
                        continue;
                    }
                    horizontalPoint[1] = Math.max(horizontalPoint[1],j + 1);
                    cnt++;
                }
            }
        }
        return horizontalPoint;
    }
}
