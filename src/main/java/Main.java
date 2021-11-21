public class Main {
    public static void main(String[] args) {

        ThreadGroup threadGroup = new ThreadGroup("Main Thread Group");

        Thread thread1 = new MyThread(threadGroup, "first thread");
        Thread thread2 = new MyThread(threadGroup, "second thread");
        Thread thread3 = new MyThread(threadGroup, "third thread");
        Thread thread4 = new MyThread(threadGroup, "fourth thread");

        startThreads(thread1, thread2, thread3, thread4);

        try {
            Thread.sleep(15_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threadGroup.interrupt();
    }

    private static void startThreads(Thread... threads) {
        for (Thread thread : threads) {
            thread.start();
        }
    }
}
