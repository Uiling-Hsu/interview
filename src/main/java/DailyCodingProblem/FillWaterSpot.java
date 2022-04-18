package DailyCodingProblem;

public class FillWaterSpot {
    public static int cal(int[] input){
        int i=0,j=0,count = 0;
        while(i<input.length && j < input.length){
            if(input[j]>=input[i]){
                i = j;
                while(i+1<input.length && input[i+1] >= input[i]){
                    i++;
                }
                if(i >= input.length){ break;}
            }
            j = i+1;
            while(j+1<input.length && input[j+1] <= input[j]){
                j++;
            }
            j++;
            if(j >= input.length){ break;}
            int min = Math.min(input[i],input[j]);
            for(int k = i+1; k <j; k++){
                count += min-input[k];
                input[k] = min;
            }
        }
        return count;
    }
    /**
     * [0, 3, 0, 1, 3, 0, 5],
     *     i     j
     *  min = 1
     *  count = 1;
     *
     *  [0, 3, 1, 1, 3, 0, 5]
     *      i        j
     *  min = 3
     *  count = 1+2+2 = 5
     *
     *  [0, 3, 3, 3, 3, 0, 5]
     *               i     j
     *
     *  min = 3
     *  count = 5 + 3 = 8
     * [0, 3, 3, 3, 3, 3, 5]
     *                   i,j
     *
     *  count = 8
     *
     *
     *
     *
     *
     *  [0, 3, 3, 5, 3, 0, 5]
     *            i        j
     */


    public static void main(String[] args){
        int[] input = new int[]{2,1,2};
        int result = FillWaterSpot.cal(input);
        System.out.println(result);
    }

}
