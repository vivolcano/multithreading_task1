import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        Future<Integer> task1 = newThreadWithCallable("First Callable", threadPool);
        Future<Integer> task2 = newThreadWithCallable("Second Callable", threadPool);
        Future<Integer> task3 = newThreadWithCallable("Third Callable", threadPool);
        Future<Integer> task4 = newThreadWithCallable("Fourth Callable", threadPool);

        System.out.println("Кол-во вызовов task1 = " + task1.get());
        System.out.println("Кол-во вызовов task2 = " + task2.get());
        System.out.println("Кол-во вызовов task3 = " + task3.get());
        System.out.println("Кол-во вызовов task4 = " + task4.get());

        threadPool.shutdown();
    }

    private static Future<Integer> newThreadWithCallable(String name, ExecutorService threadPool) {
        MyCallable callable = new MyCallable(name);
        Future<Integer> integerFutureTask = threadPool.submit(callable);
        return integerFutureTask;
    }
}
