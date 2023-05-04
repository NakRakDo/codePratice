package Programmers.Lvl1;

import java.util.*;

public class Personal_Information_Collection_Validity_Period {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = getExpirationDate(today, terms, privacies);
        return answer;
    }

    private Map<String,Integer> termToMap(String[] terms){
        //파기약관 Map 화
        Map<String, Integer> termInfo = new HashMap<>();
        for (String term : terms) {
            StringTokenizer st = new StringTokenizer(term, " ");
            termInfo.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        }
        return termInfo;
    }
    private int[] getExpirationDate(String today, String[] terms, String[] privacies){
        //파기 대상 배열
        List<Integer> subjectToExpiration = new ArrayList<>();

        Map<String, Integer> termInfo = termToMap(terms);

        for(int i = 0; i < privacies.length; i++){
            StringTokenizer st = new StringTokenizer(privacies[i]," ");
            String date = st.nextToken();
            String term = st.nextToken();

            st = new StringTokenizer(date,".");
            String year = st.nextToken();
            String month = st.nextToken();
            String day = st.nextToken();

            String expDate = calculateExpirationDate(term, year, month, day, termInfo);
            if(isExpired(today, expDate)) subjectToExpiration.add(i+1);
        }
        return subjectToExpiration.stream().mapToInt(Integer::intValue).toArray();
    }

    //파기가 시작되는 날짜 구하기
    private String calculateExpirationDate(String term, String year, String month, String day, Map<String, Integer> termInfo){
        int termValue = termInfo.get(term);

        int termValueOfYear = termValue / 12;
        int termValueOfMonth = termValue % 12;

        int expYear = Integer.parseInt(year) + termValueOfYear;
        int expMonth = 0;

        if(Integer.parseInt(month) + termValueOfMonth > 12) {
            expMonth = (Integer.parseInt(month) + termValueOfMonth) - 12;
            expYear += 1;
        } else {
            expMonth += (Integer.parseInt(month) + termValueOfMonth);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(expYear).append(".");
        if(expMonth < 10){
            sb.append("0").append(expMonth).append(".");
        }else {
            sb.append(expMonth).append(".");
        }
        sb.append(day);

        return sb.toString();
    }

    //파기여부 구하기
    private boolean isExpired(String today, String expDate){
        StringTokenizer st;
        st = new StringTokenizer(today,".");
        int todayYear = Integer.parseInt(st.nextToken());
        int todayMonth = Integer.parseInt(st.nextToken());;
        int todayDay = Integer.parseInt(st.nextToken());;

        st = new StringTokenizer(expDate,".");
        int expYear = Integer.parseInt(st.nextToken());;
        int expMonth = Integer.parseInt(st.nextToken());;
        int expDay = Integer.parseInt(st.nextToken());;

        if(todayYear - expYear > 0){
            return true;
        }else if(todayYear - expYear < 0){
            return false;
        } else if(todayYear - expYear == 0){
            if(todayMonth - expMonth > 0) {
                return true;
            } else if (todayMonth - expMonth < 0) {
                return false;
            } else if (todayMonth - expMonth == 0) {
                return todayDay - expDay >= 0;
            }
        }
        return false;
    }
}
