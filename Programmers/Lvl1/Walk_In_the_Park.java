package Programmers.Lvl1;

//Level 1  공원 산책
public class Walk_In_the_Park {

    public static final String OBSTRUTION = "X";
    public static final String ROAD = "O";
    public static final String START = "S";

    public static final String EAST = "E";
    public static final String WEST = "W";
    public static final String SOUTH = "S";
    public static final String NORTH = "N";

    public static void main(String[] args) {
        int[] result;

        //{"SOO","OOO","OOO"}	{"E 2","S 2","W 1"}	{2,1}
        //{"SOO","OXX","OOO"}	{"E 2","S 2","W 1"}	{0,1}
        //{"OSO","OOO","OXO","OOO"}	{"E 2","S 3","W 1"}	{0,0}

        //String[] park = {"OSO","OOO","OXO","OOO"}; //{"OSO","OOO","OXO","OOO"} {"SOO","OOO","OOO"} {"OOO","OOO","OSO","OXO"}
        //String[] routes = {"E 2","S 3","W 1"};

        String[] park = {"OSOOXOOOO","OOOOOOOOO","OOOOOOOOO","OOOOOOOOO","OOOOOOOOO","OXOOOOOOO","OOOOOOOOO","OOOOOOXOO","OOOOOOOOO"};
        String[] routes = {"W 3","S 3","W 1","N 2","W 2","S 3","E 5","S 3","W 1"};
        result = solution(park, routes);
    }

    private static int[] solution(String[] park, String[] routes){
        if(!checkCondition(park, routes)) return null;

        int[] curPos = new int[2]; //현재 위치
        String direction; //이동할 방향
        String moveCnt = null; //이동할 칸의수

        curPos = getStartingPoint(park); //첫 시작위치 구하기

        for(int i = 0; i < routes.length; i++){
            // 명령 행 추출하여 구분하기
            String command = routes[i];
            direction = command.substring(0,1); //방향
            moveCnt = command.substring(2,3);  // 움직이는 칸수

            int[] destPos = getDestinationPosition(curPos, direction, moveCnt); // 움직였을 때 도착지점 구하기

            if(!isMovable(curPos, destPos, park, direction, moveCnt)) continue; // 그도착 지점으로 이동할 수 있는지 여부 체크

            curPos = destPos; // 이동할 수 있다면 현재위치를 도착위치로 변경 TODO move 함수에 이식
            //Move(curPos,destPos);
        }

        return curPos; //현재 위치 반환
    }

    private static boolean checkCondition(String[] park, String[] routes) {
        if(park.length < 3 || park.length > 50) return false;
        for(int i = 0; i < park.length; i++){
            if(park[1].length() < 3 || park[i].length() > 50 ) return false;
        }

        if(routes.length < 1 || routes.length > 50) return false;

        return true;
    }

    //현재 위치 구하기
    private static int[] getStartingPoint(String[] park){
        int[] startPoint = new int[2]; //시작지점

        for(int i = 0; i < park.length; i++){
            String temp = park[i]; //시작 지점의 행
            int startPos = temp.indexOf(START); // 시작지점의 열

            if(startPos != -1) { // 그 지점이 S 라면
                startPoint[0] = i;
                startPoint[1] = startPos;
                break;
            }
        }
        return startPoint;
    }

    private static int[] getDestinationPosition(int[] curPos, String direction, String moveCnt){
        int[] expPos = {curPos[0], curPos[1]}; // 도착 예정지점 설정을 위한 현재위치 덮어 씌우기(원시 타입이라 원소를 추출하여 할당)

        // 동 or 서 방향이라면
        if(direction.equals(EAST) || direction.equals(WEST)) {
            //park 이중 배열의 열을 계산
            if(direction.equals(EAST)){
                expPos[1] = expPos[1] + Integer.parseInt(moveCnt);
            }else { // WEST
                expPos[1] = expPos[1] - Integer.parseInt(moveCnt);
            }
        //남 or 북 방향이면
        } else if (direction.equals(SOUTH) || direction.equals(NORTH)) {
            //park 이중배열의 행을 계산
            if(direction.equals(SOUTH)){
                expPos[0] = expPos[0] + Integer.parseInt(moveCnt);
            }else { //NORTH
                expPos[0] = expPos[0] - Integer.parseInt(moveCnt);
            }
        }

        // 예상 도착 지점 반환
        return expPos;
    }
    private static boolean isMovable(int[] curPos, int[] expPos, String[] park, String direction, String moveCnt){
/*        int[] expPos = curPos;

        if(direction.equals(EAST) || direction.equals(WEST)) {
            if(direction.equals(EAST)){
                expPos[1] = curPos[1] + Integer.parseInt(moveCnt);
            }else { // WEST
                expPos[1] = curPos[1] - Integer.parseInt(moveCnt);
            }

        } else if (direction.equals(SOUTH) || direction.equals(NORTH)) {
            if(direction.equals(SOUTH)){
                expPos[0] = curPos[0] + Integer.parseInt(moveCnt);
            }else { //NORTH
                expPos[0] = curPos[0] - Integer.parseInt(moveCnt);
            }
        }*/
            //이동 후 범위 체크
        if((expPos[0] < 0 || expPos[1] < 0)// 범위가 음수로 빠지거나
                || (park[curPos[0]].length() <= expPos[1] || park.length <= expPos[0])) { //범위를 벗어난다면
            return false;
            //isMovable = false;
        }
        //이동 시 장애물 체크 TODO 동쪽 양수 루프 서쪽 음수 루프 하면서 체크 (남 북도 마찬가지)
        if(direction.equals(EAST)) {
//            for(int i = curPos[1] + 1; i < park[curPos[0]].length(); i++){
            for (int i = curPos[1] + 1; i < Integer.parseInt(moveCnt) + (curPos[1] + 1); i++) { //i 는 현재위치 다음위치. 최대 loop 횟수는 도착지점 의 인덱스
                if (String.valueOf(park[curPos[0]].charAt(i)).equals(OBSTRUTION)) {
                    return false;
                }
            }
        } else if(direction.equals(WEST)){
            for (int i = curPos[1] - 1; i > (curPos[1] - 1) - Integer.parseInt(moveCnt); i--) { //i 는 현재위치 다음위치. 최대 loop 횟수는 도착지점 의 인덱스
                if (String.valueOf(park[curPos[0]].charAt(i)).equals(OBSTRUTION)) {
                    return false;
                }
            }

        } else if (direction.equals(SOUTH)) {
//            for(int i = curPos[0] + 1; i < park.length; i++){
            for(int i = curPos[0] + 1; i < Integer.parseInt(moveCnt) + (curPos[0] + 1); i++){//i 는 현재위치 다음위치. 최대 loop 횟수는 도착지점 의 인덱스
                if(String.valueOf(park[i].charAt(curPos[1])).equals(OBSTRUTION)) {
                    return false;
                }
            }
        } else if(direction.equals(NORTH)) {
            for(int i = curPos[0] - 1; i > (curPos[0] - 1) - Integer.parseInt(moveCnt); i--){//i 는 현재위치 다음위치. 최대 loop 횟수는 도착지점 의 인덱스
                if(String.valueOf(park[i].charAt(curPos[1])).equals(OBSTRUTION)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void Move(int [] curPos, int [] destPos){
        curPos = destPos;
    }
}





/*
* 지나다니는 길을 'O', 장애물을 'X'로 나타낸 직사각형 격자 모양의 공원에서 로봇 강아지가 산책을 하려합니다. 산책은 로봇 강아지에 미리 입력된 명령에 따라 진행하며, 명령은 다음과 같은 형식으로 주어집니다.

["방향 거리", "방향 거리" … ]
예를 들어 "E 5"는 로봇 강아지가 현재 위치에서 동쪽으로 5칸 이동했다는 의미입니다. 로봇 강아지는 명령을 수행하기 전에 다음 두 가지를 먼저 확인합니다.

주어진 방향으로 이동할 때 공원을 벗어나는지 확인합니다.
주어진 방향으로 이동 중 장애물을 만나는지 확인합니다.
*

공원을 나타내는 문자열 배열 park, 로봇 강아지가 수행할 명령이 담긴 문자열 배열 routes가 매개변수로 주어질 때, 로봇 강아지가 모든 명령을 수행 후 놓인 위치를 [세로 방향 좌표, 가로 방향 좌표] 순으로 배열에 담아 return 하도록 solution 함수를 완성해주세요.

제한사항
3 ≤ park의 길이 ≤ 50
3 ≤ park[i]의 길이 ≤ 50
park[i]는 다음 문자들로 이루어져 있으며 시작지점은 하나만 주어집니다.
S : 시작 지점
O : 이동 가능한 통로
X : 장애물
park는 직사각형 모양입니다.
1 ≤ routes의 길이 ≤ 50
routes의 각 원소는 로봇 강아지가 수행할 명령어를 나타냅니다.
로봇 강아지는 routes의 첫 번째 원소부터 순서대로 명령을 수행합니다.
routes의 원소는 "op n"과 같은 구조로 이루어져 있으며, op는 이동할 방향, n은 이동할 칸의 수를 의미합니다.
op는 다음 네 가지중 하나로 이루어져 있습니다.
N : 북쪽으로 주어진 칸만큼 이동합니다.
S : 남쪽으로 주어진 칸만큼 이동합니다.
W : 서쪽으로 주어진 칸만큼 이동합니다.
E : 동쪽으로 주어진 칸만큼 이동합니다.
1 ≤ n ≤ 9
입출력 예
park	routes	result
["SOO","OOO","OOO"]	["E 2","S 2","W 1"]	[2,1]
["SOO","OXX","OOO"]	["E 2","S 2","W 1"]	[0,1]
["OSO","OOO","OXO","OOO"]	["E 2","S 3","W 1"]	[0,0]
입출력 예 설명
입출력 예 #1

입력된 명령대로 동쪽으로 2칸, 남쪽으로 2칸, 서쪽으로 1칸 이동하면 [0,0] -> [0,2] -> [2,2] -> [2,1]이 됩니다.

입출력 예 #2

입력된 명령대로라면 동쪽으로 2칸, 남쪽으로 2칸, 서쪽으로 1칸 이동해야하지만 남쪽으로 2칸 이동할 때 장애물이 있는 칸을 지나기 때문에 해당 명령을 제외한 명령들만 따릅니다. 결과적으로는 [0,0] -> [0,2] -> [0,1]이 됩니다.

입출력 예 #3

처음 입력된 명령은 공원을 나가게 되고 두 번째로 입력된 명령 또한 장애물을 지나가게 되므로 두 입력은 제외한 세 번째 명령만 따르므로 결과는 다음과 같습니다. [0,1] -> [0,0]
*
*
*
* */
