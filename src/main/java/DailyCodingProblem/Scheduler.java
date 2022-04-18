package DailyCodingProblem;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Scheduler {
    Map<Runnable,Long> taskDelayMapping = new HashMap();
    PriorityQueue<Runnable> minHeap = new PriorityQueue<Runnable>((a,b)->{return Long.compare(taskDelayMapping.get(a),taskDelayMapping.get(b));}
    );
    boolean stop = false;
    public Scheduler(){
        Thread thread = new Thread(()->{
            while(!stop){
                Runnable f =  minHeap.peek();
                if(taskDelayMapping.get(f) != null &&taskDelayMapping.get(f) <= System.currentTimeMillis()){
                    minHeap.poll();
                    taskDelayMapping.remove(f);
                    f.run();

                }
            }

        });
        thread.start();
    }

    public void delaySchedule(long millis, Runnable f){
        taskDelayMapping.put(f,millis+System.currentTimeMillis());
        minHeap.add(f);
    }

    public void stop(){
        this.stop = true;
    }

    public static void main(String[] args){
        Scheduler scheduler = new Scheduler();
        scheduler.delaySchedule(1000,()->{System.out.println("a");});
        scheduler.delaySchedule(2000,()->{System.out.println("b");});
//        scheduler.stop();
    }


}
