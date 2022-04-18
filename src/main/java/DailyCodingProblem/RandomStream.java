package DailyCodingProblem;

import java.util.*;

public class RandomStream {
    public static int[] uniformKRandomFromStream(int[] stream, int k){
        int[] result = new int[k];
        for(int i = 0; i < stream.length; i++){
            if(i < k){
                result[i] = stream[i];
            }else {
                Random random = new Random();
                int r = random.nextInt(i);
                if (r < k) {
                    //replace result[r] with stream[i]
                    result[r] = stream[i];
                }
            }
        }
        return result;

    }

    public static int[] uniformKRandomFromStream2(int[] stream, int k){
        // keep k largest random associated value with min heap
        PriorityQueue<Tuple> minHeap  = new PriorityQueue<Tuple>((a, b) -> {return Double.compare(a.key,b.key);});
        for(int input : stream){
            double r = Math.random();
            if(minHeap.size() < k){
                minHeap.offer(new Tuple(r,input));
            }else{
                if(r > minHeap.peek().key){
                    minHeap.poll();
                    minHeap.offer(new Tuple(r,input));
                }
            }
        }

        int[] result = new int[minHeap.size()];
        for(int i = 0 ; i < result.length; i++){
            result[i] = minHeap.poll().value;
        }
        return result;

    }

    static class Tuple{
        double key;
        int value;
        Tuple(double key, int value){
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args){
        int[] input = new int[]{1,2,3,4,5,6};
//        int[] result = RandomStream.uniformKRandomFromStream(input, 3);
        int[] result = RandomStream.uniformKRandomFromStream2(input,3);
        System.out.println(Arrays.toString(result));

    }
}
