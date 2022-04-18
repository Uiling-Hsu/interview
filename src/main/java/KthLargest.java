import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KthLargest {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b)->(b-a));

    int k = 0;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int n: nums){
            maxHeap.offer(n);
        }
    }

    public int add(int val) {
        maxHeap.add(val);
        List<Integer> temp = new ArrayList();
        int i = 0;
        int result = 0;
        while(i < k){ //O(klogn)
            result= maxHeap.poll();
            temp.add(result);
            i++;
        }
        for(Integer t :temp){ // O(klogn)
            maxHeap.offer(i);
        }
        return result;
    }

    public static void main(String[] args){
        KthLargest kthLargest = new KthLargest(3, new int[]{4,5,8,2});
        kthLargest.add(3);
        kthLargest.add(6);
        kthLargest.add(10);
        kthLargest.add(9);
        kthLargest.add(4);

    }
}
