package threads;

/**
 * Exception Handlers are handled in the same thread.
 */
public class ParallelException {
    public static void main(String[] args) {
        Handler exceptionHandler = new Handler();
        System.out.println("Main Thread is " + Thread.currentThread().getId());
        Thread t = new Thread(() -> {
            System.out.println("test is running from: " + Thread.currentThread().getId());
            throw new RuntimeException("HELLO");
        });
        t.setUncaughtExceptionHandler(exceptionHandler);

        t.start();

        Thread t2 = new Thread(() -> {
            System.out.println("test is running from: " + Thread.currentThread().getId());
            throw new RuntimeException("Thread 2");
        });
        t2.setUncaughtExceptionHandler(exceptionHandler);
        t2.start();
    }
}


class Handler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable te) {
        System.out.println("ERROR has been thrown caught in this thread id: " +
                Thread.currentThread().getId());
    }
}




