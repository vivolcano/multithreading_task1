import java.util.Random;
import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {

    public static Random random = new Random();

    private final String name;

    public MyCallable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public Integer call() throws Exception {
        int count = random.nextInt(10);
        for (int i = 0; i < count; i++) {
            System.out.println("Hi! I'm " + getName() + "!");
        }
        return count;
    }
}
