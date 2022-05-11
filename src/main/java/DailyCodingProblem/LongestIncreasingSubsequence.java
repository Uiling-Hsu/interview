package DailyCodingProblem;

public class LongestIncreasingSubsequence {
    public static int longIncSub(int[] arr){
        int[] record = new int[arr.length];
        int result = 0;
        for(int i = arr.length-1; i>=0; i--){
            int maxCount = 0;
            for(int j = i+1; j < arr.length; j++){
                if(arr[j] >= arr[i]){
                    maxCount = Math.max(maxCount,record[j]);
                }
            }
            maxCount+=1;
            record[i] = maxCount;
            result = Math.max(result,record[i]);
        }
        return result;

    }

    //O(n^2)

    public static void main(String[] args){
        int[] input = new int[]{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        int result =LongestIncreasingSubsequence.longIncSub(input);
        System.out.println(result);

    }
}
