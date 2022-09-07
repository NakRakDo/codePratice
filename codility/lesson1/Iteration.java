package codility.lesson1;

public class Iteration {
    public static void main(String[] args) {
        //System.out.println(Math.pow(2,0));
        System.out.println(getBinaryNum(62));
        System.out.println(getBinaryNum(63));
        System.out.println(getBinaryNum(38));
        System.out.println(getBinaryNum(16));
        System.out.println(getBinaryNum(2));
        System.out.println(getBinaryNum(4));
        System.out.println(getBinaryNum(8));
        System.out.println(getBinaryNum(32));
        System.out.println(getBinaryNum(15));
        System.out.println(getBinaryNum(7));

    }

    public static int Solution(int N) {



        return 0;
    }

    public static int getBinaryNum(int N) {
        int index = 1;
        if(N <= 1) return N;
        while(true){
            if((Math.pow(2,index) <= N && (Math.pow(2,(index+1))) > N)) break;
            index++;
        }

        double BinaryNum = Math.pow(10,index);
        double temp = N - Math.pow(2,index);


        for(int i = index-1; i > 0; i--){
            if(i == 1){
                if((temp - (Math.pow(2,i)) == 0)){
                    BinaryNum += Math.pow(10,i);
                }else if((temp - (Math.pow(2,i)) == 1)){
                    BinaryNum += Math.pow(10,i)+1;
                }
                break;
            }else{
                if((temp - (Math.pow(2,i)) >= (Math.pow(2,(i-1))))){
                    BinaryNum += Math.pow(10,i);
                    temp -= Math.pow(2,i);
                }
            }

        }
        return (int)BinaryNum;
    }

}
