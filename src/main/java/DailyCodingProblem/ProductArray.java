package DailyCodingProblem;

import java.util.Arrays;

public class ProductArray{
    public static int[] product(int[] input){
        int[] prefix = new int[input.length];
        prefix[0]  = 1;
        for(int i = 1; i< prefix.length;i++){
            prefix[i] = input[i-1] *prefix[i-1];
        }

        int rightAccumulate = 1;
        for(int i = prefix.length-2; i>=0; i--){
            rightAccumulate = input[i+1] * rightAccumulate;
            prefix[i] = prefix[i] * rightAccumulate;
        }
        return prefix;
    }

    public static void main(String[] args){
        int[] result = ProductArray.product(new int[]{1,2,3,4,5});
        System.out.println(Arrays.toString(result));
    }


}
