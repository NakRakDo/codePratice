package codility.lesson2;

public class array1 {

    //CyclicRotation
    public static void main(String[] args) {
        int[] a = {1, 5, 2, 9, 7, 6, 4};
        int k = 37;
        int[] answer = new int[0];
        //Chk necessity of rotation or Get minimum counts of rotate;
        //add condition checking array size of 0;
        if(a.length <= 0 || a == null) return;

        k = preChkNecessityOfRotate(a.length, k);

        //If there is no need to rotate last index;
        if (k == -1) {
            for (int i = 0; i < a.length; i++) {
                System.out.println(a[i]);
            }
            return;
        }

        //After rotate k times;
        answer = rotateArray(a, k);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }

    public static int[] rotateArray(int[] a, int k) {

        int[] answer = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            answer[(i + k) % a.length] = a[i];
        }
        return answer;
    }

    public static int preChkNecessityOfRotate(int a, int k) {
        if (k == 0 || k % a == 0) {
            return -1;
        }
        return k % a;
    }

}
