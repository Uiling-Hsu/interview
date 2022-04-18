package DailyCodingProblem;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinRoom {
    public static int minRoom(int[][] schedule){
        if(schedule.length == 0) return 0;
        Arrays.sort(schedule, (a, b)->(a[0]-b[0]));
        PriorityQueue<Integer> minHeap = new PriorityQueue();
        minHeap.offer(schedule[0][1]);
        for(int i = 1; i< schedule.length; i++){
            if(schedule[i][0] >=  minHeap.peek()) {
                minHeap.poll();
            }
            minHeap.offer(schedule[i][1]);

        }
        return minHeap.size();
    }
    public static void main(String[] args){
        System.out.println(MinRoom.minRoom(new int[][]{{30,75},{0,50},{60,150}}));
    }

}
