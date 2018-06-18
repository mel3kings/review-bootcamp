package threads;

import java.util.stream.IntStream;

public class BasicRunnable {
    public static void main(String[] args) {
        Thread t = new Thread(new Runner("first"));
        Worker t2 = new Worker();

        t.start();
        t2.start();
    }
}

class Runner implements Runnable {
    private String name;
    public Runner(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        IntStream.range(0, 50).forEach(range -> System.out.println(name + " : " + range));
    }
}

class Worker extends Thread{
    @Override
    public void run() {
        IntStream.range(0, 50).forEach(range -> System.out.println("Worker: " + range));
    }
}