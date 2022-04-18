package DailyCodingProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Median {
    public static List<Double> record = new ArrayList();
    public static List<Double> findMedian(List<Double> input){
        List<Double> result = new ArrayList();
        int m = -1;
        for(double n: input ){
            int pos = findPosition(n);
           if(record.size() != 0 && n > record.get(pos)){
                pos = pos+1;
            }
            record.add(pos,n);
            if(record.size()%2 == 0){
                result.add((record.get(m) + record.get(m+1))/2);
            }else{
                m = m+1;
                result.add(record.get(m));
            }
        }
        return result;

    }

    public static int findPosition(double num){
        int start = 0, end = record.size()-1;
        while(start < end){
            int pivot = start + (end-start)/2;
            if(num == record.get(pivot)){
                return pivot;
            }
            if(num < record.get(pivot)){
                end = pivot -1;
            }else{
                start  = pivot +1;
            }
        }
        return start;
    }


    public static void main(String[] args){
        List<Double> input = Arrays.asList(new Double[]{2d,1d,5d,7d,2d,0d,5d});
        List<Double> result = Median.findMedian(input);
        System.out.println(result.toString());

    }
}
