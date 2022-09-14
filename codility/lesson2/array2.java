package codility.lesson2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

public class array2 {

    //OddOccurrencesInArray
    public static void main(String[] args) {
        int[] array = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10, 11, 11, 12, 12,
            13, 13, 14, 14, 15, 15, 16, 16, 17, 17, 18, 18, 19, 19, 20, 20, 21, 21, 22, 22, 23, 23,
            24, 24, 25, 25, 26, 26, 27, 27, 28, 28, 29, 29, 30, 30, 31, 31, 31, 31, 42, 55, 55, 100,
            100};/*{9, 3, 9, 3, 9, 7, 9};*/
        System.out.println(getOddNum(array));
    }

    public static int getOddNum(int[] a) {
        Map<Integer, Integer> numCnts = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            put(numCnts, a[i]);
        }
        // Lamda expression -> Occurs timeout in specific condition.
        //Optional<Integer> answer = numCnts.entrySet().stream().filter(e -> e.getValue() % 2 == 1)
        //    .map(Map.Entry::getKey).findFirst();

        Iterator<Entry<Integer, Integer>> it = numCnts.entrySet().iterator();

        Entry<Integer, Integer> target = null;
        int key = 0;

        while (it.hasNext()) {
            target = it.next();
            if (target.getValue() % 2 == 1) {
                key = target.getKey();
                break;
            }
        }

        return key;
    }


    public static void put(Map<Integer, Integer> map, int k) {
        if (map.containsKey(k)) {
            map.put(k, map.get(k) + 1);
        } else {
            map.put(k, 1);
        }
    }
}
