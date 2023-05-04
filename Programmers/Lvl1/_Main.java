package Programmers.Lvl1;

public class _Main {
    public static void main(String[] args) {
        //Clean_Up_the_WallPaper
        //예제
        //{".#...", "..#..", "...#."}
        //{"..........", ".....#....", "......##..", "...##.....", "....#....."}
        //{".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."}
        /*Clean_Up_the_WallPaper clean_up_the_wallPaper = new Clean_Up_the_WallPaper();
        String[] wallPaper = {".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."};
        clean_up_the_wallPaper.solution(wallPaper);*/

        //Personal_Information_Collection_Validity_Period
        //예제
        //"2022.05.19"	["A 6", "B 12", "C 3"]	["2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"]
        //"2020.01.01"	["Z 3", "D 5"]	["2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"]
        Personal_Information_Collection_Validity_Period personal_information_collection_validity_period = new Personal_Information_Collection_Validity_Period();
        String today = "2020.01.01";
        String[] terms = {"Z 3", "D 5"};
        String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};

        personal_information_collection_validity_period.solution(today, terms, privacies);
    }
}
