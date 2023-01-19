package leetCode.basic;

public class Number_of_Steps_to_Reduce_a_Number_to_Zero {
    public static void main(String[] args) {
        System.out.println(numberOfSteps(14));
        System.out.println(numberOfSteps(8));
        System.out.println(numberOfSteps(123));
    }

    public static int numberOfSteps(int num) {
        int count = 0;
        while(num != 0){
            num = (num % 2 == 0) ? (num / 2) : (num - 1);
            ++count;
        }
        return count;
    }
}
