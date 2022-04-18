import java.util.concurrent.*;

public class ExecutorPractice {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduleExecutorService = Executors.newScheduledThreadPool(2);
        Callable<String> task = () -> {return "1";};
        ScheduledFuture<String> future = scheduleExecutorService.schedule(task,2, TimeUnit.SECONDS);
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println(future.getDelay(TimeUnit.MILLISECONDS));
        try {
            System.out.println(future.get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        scheduleExecutorService.shutdown();
    }
}
