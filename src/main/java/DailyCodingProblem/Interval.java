package DailyCodingProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Interval {
    public static List<int[]> overlap(List<int[]> intervals){
        List<int[]> result = new LinkedList();
        intervals.sort((a,b) -> (a[0]-b[0]));
        result.add(intervals.get(0));
        for(int i = 1; i < intervals.size(); i++){
            int[] latest = result.get(result.size()-1);
            int[] current = intervals.get(i);
            if(current[0] <= latest[1]){
                if(current[1] >= latest[1]){
                    latest[1] = current[1];
                }
            }else{
                result.add(current);
            }
        }
        return result;
    }

    public static void main(String[] args){
        List<int[]> input =  new ArrayList<>();
        input.add(new int[]{1,3});
        input.add(new int[]{5,8});
        input.add(new int[]{4,10});
        input.add(new int[]{20,25});
        List<int[]> result = Interval.overlap(input);
        for(int[] r: result){
            System.out.println(r[0] + " " + r[1]);
        }

    }

}
