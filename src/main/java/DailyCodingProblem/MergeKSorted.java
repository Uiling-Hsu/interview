package DailyCodingProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeKSorted {
    public static List<Integer> mergeKSorted(List<List<Integer>> lists){
        List<Integer> temp;
        while(lists.size()!= 1){
            List l1=lists.remove(0);
            List l2 = lists.remove(0);
            lists.add(merge(l1,l2));
        }
        return lists.get(0);
    }

    public static List<Integer> merge(List<Integer> l1, List<Integer> l2){
        int i=0, j = 0;
        List<Integer> result = new ArrayList();
        while(i != l1.size() && j != l2.size()){
            if(l1.get(i) <= l2.get(j) ){
                result.add(l1.get(i));
                i+=1;
            }else{
                result.add(l2.get(j));
                j+=1;
            }
        }
        if(i!= l1.size()){
            for( ;i<l1.size(); i++){
                result.add(l1.get(i));
            }
        }
        if(j!= l2.size()){
            for(; j<l2.size(); j++ ){
                result.add(l2.get(j));

            }
        }
        return result;
    }

    public static void main(String[] a){
        Integer[] a1 = new Integer[]{1,3,5,7,9,11,13};
        Integer[] a2 = new Integer[]{2,4,6,8};
        Integer[] a3 = new Integer[]{10,12,14,100};
        List<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.asList(a1));
        input.add(Arrays.asList(a2));
        input.add(Arrays.asList(a3));
        List r = MergeKSorted.mergeKSorted(input);
        System.out.println(r);

    }

}
