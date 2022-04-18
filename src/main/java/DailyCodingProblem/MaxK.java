package DailyCodingProblem;

import java.util.PriorityQueue;

public class MaxK {
    public static void maxK(int[] input, int k){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) ->  b-a);
        for(int i = 0 ; i < input.length; i++){
            maxHeap.offer(input[i]);
            if(maxHeap.size() == k){
                System.out.println(maxHeap.peek());
                maxHeap.remove(input[i-k+1]);
            }
        }
    }

    public static void main(String[] args){
        MaxK.maxK(new int[]{10, 5, 2, 7, 8, 7}, 3);
    }

}
