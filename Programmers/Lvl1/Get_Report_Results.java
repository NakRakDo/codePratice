package Programmers.Lvl1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

//Level 1  공원 산책
public class Get_Report_Results {


    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        //String[] id_list = {"con", "ryan"};
        //String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
        //int k =3;

        solution(id_list, report, k);

    }

    private static int[] solution(String[] id_list, String[] report, int k) {
        //if(!checkCondition(id_list, report, k)) return null;

        //누적횟수 계산을 위한 Map 객체 생성 및 초기화 처리
        Map<String, ArrayList<String>> reportInfo = new HashMap<>();
        for (String s : id_list) {
            reportInfo.put(s, new ArrayList<>());
        }
        //이메일 발송 대상 횟수를 누적하기 위한맵
        Map<String, Integer> emailRecipientInfo = new HashMap<>();
        for (String s : id_list) {
            emailRecipientInfo.put(s, 0);
        }

        report(reportInfo,report);
        sendEmail(reportInfo, emailRecipientInfo, k);

        int[] result = new int[id_list.length];
        for(int i = 0; i < id_list.length; i++){
            result[i] = emailRecipientInfo.get(id_list[i]);
        }

        return result;
    }

    private static boolean checkCondition(String[] id_list, String[] report, int k) {

        return true;
    }

    private static void report(Map<String, ArrayList<String>> reportInfo, String[] report) {
        for(String s: report) {
            StringTokenizer st = new StringTokenizer(s," ");
            String reporter = st.nextToken();//신고자
            String reported = st.nextToken();//피신고자
            ArrayList<String> reporterList = reportInfo.get(reported);//피신고자에 대한 신고자 리스트()
            if(reporterList.contains(reporter)) continue; // 신고자 리스트에 현재 신고자가 있다면
            reporterList.add(reporter);//피신고자에 대한 신고자리스트에 신고자 추가.
        }
    }

    private static void sendEmail(Map<String, ArrayList<String>> reportInfo, Map<String, Integer> emailRecipientInfo, int k) {
        for(String id : reportInfo.keySet()){
            ArrayList<String> reporterList = reportInfo.get(id);
            if(reporterList.size() < k) continue;
            for (String reporter : reporterList) {
                emailRecipientInfo.put(reporter, emailRecipientInfo.get(reporter) + 1);
            }
        }
    }

}
