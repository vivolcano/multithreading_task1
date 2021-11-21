class MyThread extends Thread {

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
    }

    @Override
    public void run() {
        try {
            while(!isInterrupted()) {
                Thread.sleep(2_500);
                System.out.println("Hello everyone, my name is " + getName() + "!");
            }
        } catch (InterruptedException ignored) {

        } finally{
            System.out.printf("%s completed\n", getName());
        }
    }
}

