package DailyCodingProblem;

import java.util.HashMap;
import java.util.Map;

public class LargeSum{

    public static int sum(int[] input) {
        return findLarge(input, 0, new HashMap());
    }


    /* F(n) = max(i[n] + F(n-2), F(n-1) ), n > 2
    *  F(0) = max(0,i[0]), F(1) = max(i[0],i[1])
    * */
    public static int sumWithConstantSpace(int[] input){

        if(input.length < 3) return Math.max(input[0],input[1]);
        //F(0)
        int preExcludingMax = Math.max(0,input[0]); // i-2
        //F(1)
        int preIncludingMax= Math.max(input[0],input[1]); //i-1
        int currentMax =0;
        for(int i = 2; i < input.length; i++){
            currentMax = Math.max(input[i]+preExcludingMax,preIncludingMax );
            preExcludingMax = preIncludingMax;
            preIncludingMax = currentMax;
        }
        return currentMax;
    }



    public static int findLarge(int[] input, int index, Map<Integer, Integer> cache){
        if(input == null) return 0;
        if(index > input.length-1) return 0;
        if(cache.get(index) != null) return cache.get(index);
        int result = Math.max(input[index] + findLarge(input, index+2,cache) , findLarge(input, index+1,cache));
        cache.put(index, result);
        return cache.get(index);
    }

    public static void  main(String[] args){
        int[] input = new int[]{5,1};
        System.out.println(LargeSum.sum(input));
        System.out.println(LargeSum.sumWithConstantSpace(input));
    }
}

