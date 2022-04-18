package asus;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    // [1,1,5,5,3,3,3] , k =6
    //

    public static int validPair(int[] input, int k, int start){
        Map<Integer,Integer> record = new HashMap();
        int result = 0;
        for(int i= start; i< input.length; i++){
            if(record.get(input[i]) != null){
                result+=record.get(input[i]);
            }
            int minus = k - input[i];
            Integer v = record.getOrDefault(minus,0);
            record.put(minus,v+1);
        }
        return result;
    }

    public static int validTuple(int[] input, int k){
        int result = 0;
        for(int i = 0; i < input.length; i++){
            result += validPair(input,k-input[i],i+1);
        }
        return result;

    }

    public static void main(String[] args){
        System.out.println(TwoSum.validPair(new int[]{1,1,5,5,3,3,3},6, 0));
        System.out.println(TwoSum.validTuple(new int[]{2,2,2,2,2},6));
    }
}

/*
*
* {{5:2}}
*
*
*
*
* */
