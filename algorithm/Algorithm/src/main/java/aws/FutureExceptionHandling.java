package aws;

import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class FutureExceptionHandling {

    public static void main(String[] args) throws Exception {
        FutureExceptionHandling p = new FutureExceptionHandling();
        CompletableFuture future = CompletableFuture.runAsync(() -> p.counter())
                .thenRun(FutureExceptionHandling::counter2).exceptionally(t -> {
                    System.out.println(t.getMessage());
                    return null;
                })
                .thenRun(() -> p.finish()).thenRun(() ->
                        System.out.println("DO final commits here"));
        future.get();


        CompletableFuture parser = CompletableFuture.supplyAsync(() -> "1")
                .thenApply(Integer::parseInt)
                .exceptionally(t -> {
                    t.printStackTrace();
                    return 0;
                }).thenAcceptAsync(s -> System.out.println("CORRECT value: " + s));

        parser.get();


        CompletableFuture correctHandler = CompletableFuture.supplyAsync(() -> "A")
                .thenApply(Integer::parseInt)
                .handle((result, ex) -> {
                    if (null != ex) {
                        ex.printStackTrace();
                        return 0;
                    } else {
                        System.out.println("HANDLING " + result);
                        return result;
                    }
                })
                .thenAcceptAsync(s -> {
                    System.out.println("CORRECT: " + s);
                });
        correctHandler.get();

        CompletableFuture correctHandler2 = CompletableFuture.supplyAsync(() -> "A")
                .thenApply(Integer::parseInt)
                .whenComplete((result, ex) -> {
                    if (null != ex) {
                        ex.printStackTrace();
                    }
                })
                .thenAcceptAsync(s -> {
                    System.out.println("when Complete: " + s);
                });
        correctHandler2.get();

    }


    public void counter() {
        IntStream.range(1, 50).forEach(System.out::println);
    }

    public static void counter2() {
        IntStream.range(1, 50).forEach(i -> System.out.println("A:" + i));
        throw new NullPointerException("NPE");
    }

    public void finish() {
        System.out.println("FINISHED!");
        System.out.println("!!FINISHED!");
    }

}
