package leetCode.basic;

import java.util.HashMap;
import java.util.Map;

public class Ransom_Note {

    public static void main(String[] args) {
        //System.out.println(canConstruct1("aa","aabccc"));
        //System.out.println(canConstruct1("aabccd","aabccc"));
        System.out.println(canConstruct1("aazbz","aazhhbhhhz"));

    }

    private static boolean canConstruct1(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length())
            return false;
        int[] arr = new int[26]; // -97
        for(int i=0; i<ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            int val = magazine.indexOf(c, arr[c-'a']);
            if (val == -1) return false;
            arr[c-'a'] = val+1;
        }
        return true;
    }

    private static boolean canConstruct(String ransomNote, String magazine) {

        Map<String,Integer> magazineMap = convertMagazineToMap(magazine);

        for(int i = 0; i < ransomNote.length(); i++){
            String ch = String.valueOf(ransomNote.charAt(i));
            if(magazineMap.get(ch) != null && magazineMap.get(ch) > 0){
                magazineMap.put(ch, magazineMap.get(ch) - 1);
                continue;
            }else {
                return false;
            }
        }
        return true;
    }

    private static Map<String, Integer> convertMagazineToMap(String magazine){
        Map<String,Integer> magazineMap = new HashMap<>();
        for(int i = 0; i < magazine.length(); i++){
            String ch = String.valueOf(magazine.charAt(i));

            if(!magazineMap.containsKey(ch)){
                magazineMap.putIfAbsent(ch,1);
                continue;
            }
            magazineMap.put(ch,magazineMap.get(ch)+1);
        }
        return magazineMap;
    }
}
