package codility.lesson1;
import java.math.BigInteger;

public class Iteration {
    //BinaryGap
    public static void main(String[] args) {

        System.out.println("Binary Num : " + getBinaryNum(561892));
        System.out.println("Gap : " + calculateGap(getBinaryNum(561892)));
    }
    public static int calculateGap(BigInteger N) {

        char[] binaryNumToString = String.valueOf(N.toString()).toCharArray();

        int prevIndex = 0;
        int nextIndex = 0;
        int gap = 0;

        for(int i = 0; i < binaryNumToString.length; i++){
            if(binaryNumToString[i] == '1'){
                prevIndex = nextIndex;
                nextIndex = i;
            }
            if(((nextIndex-1) - prevIndex) > 0){
                gap = ((nextIndex-1) - prevIndex) >= gap ? ((nextIndex-1) - prevIndex) : gap;
            }
        }

        if(gap <= 0) return 0;
        return gap;
    }

    public static BigInteger getBinaryNum(int N) {
        BigInteger bigN = BigInteger.valueOf(N);
        int index = 1;
        if(N <= 1) return bigN;
        while(true){

            if((( bigN.compareTo(BigInteger.valueOf(2).pow(index)) == 1
                    || bigN.compareTo(BigInteger.valueOf(2).pow(index)) ==0 ))
                    && bigN.compareTo(BigInteger.valueOf(2).pow(index+1)) ==-1 ){
                break;
            }
            index++;
        }
        BigInteger binaryNum = BigInteger.valueOf(10).pow(index);
        BigInteger temp = bigN.subtract(BigInteger.valueOf(2).pow(index));

        for(int i = index-1; i > 0; i--){
            if(i == 1) {
                if((temp.subtract(BigInteger.valueOf(2).pow(i)).equals(BigInteger.valueOf(0)))){
                    binaryNum = binaryNum.add(BigInteger.valueOf(10).pow(i));
                }else if((temp.subtract(BigInteger.valueOf(2).pow(i)).equals(BigInteger.valueOf(1)))){
                    binaryNum = binaryNum.add(BigInteger.valueOf(10).pow(i)).add(BigInteger.valueOf(1));
                }else if(temp.equals(1)){
                    binaryNum = binaryNum.add(BigInteger.valueOf(1));
                }
            }else{
                if((temp.subtract(BigInteger.valueOf(2).pow(i)).compareTo(BigInteger.valueOf(0))) == 1 ||
                      (temp.subtract(BigInteger.valueOf(2).pow(i)).compareTo(BigInteger.valueOf(0))) == 0){
                    binaryNum = binaryNum.add(BigInteger.valueOf(10).pow(i));
                    temp = temp.subtract(BigInteger.valueOf(2).pow(i));
                }
            }
        }
        return binaryNum;
    }
}


/*
import java.util.*;

class Solution {
    public int solution(int N) {
        if(N > 2147483647 && N < 1) return -1;
        return caculateGap(getBinaryNum(N));
    }

    public int caculateGap(long N) {
        char[] binaryNumToString = String.valueOf(N).toCharArray();
        int prevIndex = 0;
        int nextIndex = 0;
        int gap = 0;

        for(int i = 0; i < binaryNumToString.length; i++){
            if(binaryNumToString[i] == '1'){
                prevIndex = nextIndex;
                nextIndex = i;
            }
            if(((nextIndex-1) - prevIndex) > 0){
                gap = ((nextIndex-1) - prevIndex) >= gap ? ((nextIndex-1) - prevIndex) : gap;
            }
        }
        if(gap <= 0) return 0;
        return gap;
    }

    public long getBinaryNum(int N){
        int index = 1;
        if(N <= 1) return N;
        while(true){
            if(((long)Math.pow(2,index) <= N && ((long)Math.pow(2,(index+1)))>N)) break;
            index++;
        }

        long binaryNum = (long)Math.pow(10,index);
        long temp = N - (long)Math.pow(2,index);

        for(int i = index-1; i > 0; i--){
            if(i == 1) {
                if((temp - ((long)Math.pow(2,i)) == 0)){
                    binaryNum += (long)Math.pow(10,i);
                }else if((temp - ((long)Math.pow(2,i)) == 1)){
                    binaryNum += (long)Math.pow(10,i)+1;
                }else if(temp == 1){
                    binaryNum += 1;
                }
                break;
            }else{
                if((temp - ((long)Math.pow(2,i)) >= 0)){
                    binaryNum += (long)Math.pow(10,i);
                    temp -= (long)Math.pow(2,i);
                }
            }
        }
        return binaryNum;
    }
}

* */