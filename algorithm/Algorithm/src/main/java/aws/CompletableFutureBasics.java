package aws;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureBasics {

    /**
     * Ideally methods in the future does not run until .get
     * they are also non-blocking
     *
     * @throws Exception
     */
    @Test
    public void testNormalFuture() throws Exception {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("inside async hello");
            return "hello";
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("inside async world");
            return "world";
        });
        System.out.println("break");
        System.out.println("break2");
        String result = future.get();
        assert (future2.get().equals("world"));
        assert (result.equals("hello"));
    }

    @Test
    public void testSimpleThenApply() throws Exception {
        CompletableFuture hello =
                CompletableFuture.supplyAsync(() -> "Hello").thenApplyAsync(s -> s + " World");
        assert (hello.get().equals("Hello World"));
    }

    @Test
    public void testDoCompose() {
        CompletableFuture.supplyAsync(() -> "Hello").thenApply(s -> s + " World").thenAcceptAsync(s -> {
            System.out.println(s + " is done");
        });
    }


}
