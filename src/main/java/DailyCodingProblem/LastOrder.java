package DailyCodingProblem;

import java.util.ArrayList;

public class LastOrder {
    ArrayList<Integer> record = new ArrayList();
    int lastNum = 0;


    public LastOrder(int lastNum){
        this.lastNum = lastNum;
    }

    //O(1)
    public void record(int order_id){
        record.add(order_id);
        if(record.size() >lastNum){
            record.remove(0);
        }
    }

    //O(N)
    public int getLast(int i){ // getLast(1) == record.get(record.size()-1)
        for(int index = 1; index <= record.size(); index++){
            if(index == i){
                return record.get(record.size() - index);
            }
        }
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args){
        LastOrder lastOrder = new LastOrder(5);
        int[] input = new int[]{1,2,3,4,5,6,7,8,9,10};
        for(int i: input){
            lastOrder.record(i);
        }
        int result = lastOrder.getLast(6);
        System.out.println(result);
    }

}
