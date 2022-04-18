package DailyCodingProblem;

import java.util.HashSet;
import java.util.Set;

public class TwoSum {
    public static boolean twoSum(int[] nums, int k){
        Set<Integer> visited = new HashSet();
        for(int i = 0; i < nums.length; i++){
            int remain = k-nums[i];
            if(visited.contains(new Integer(remain))){
                return true;
            }else{
                visited.add(nums[i]);
            }
        }
        return false;
    }

    public static void main(String[] args){
        boolean result = TwoSum.twoSum(new int[]{15,12,13,5}, 20);
        System.out.println(result);
    }

}
