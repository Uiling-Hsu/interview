package DailyCodingProblem;

import java.util.List;

public class MaxNProd {


    public static int prod(int[] input, int count){
        if(count == 0 || input.length < count){
            return 0;
        }
        return max(input, 0, count, 1);
    }
    public static int max(int[] input,int index, int count, int prod){
        if(count == 0){
            return prod;
        }
        if(input.length - index< count){
            return Integer.MIN_VALUE;
        }
        int withCurrent = max(input, index+1, count-1, prod*input[index]);
        int withoutCurrent = max(input, index+1, count, prod);
        return Math.max(withCurrent,withoutCurrent);
    }

    public static void main(String[] args){
        int[] input = new int[]{-1, -5, -3, -2};
        int result = max(input, 0,3,1);
        System.out.println(result);
    }
}
