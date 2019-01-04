package aws;

import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class NestedException {

    public static void main(String[] args) throws Exception {
        NestedException p = new NestedException();
        CompletableFuture future = CompletableFuture.runAsync(() -> p.counter())
                .thenRun(NestedException::counter2).exceptionally(t -> {
                    System.out.println(t.getMessage());
                    return null;
                })
                .thenRun(() -> p.finish()).thenRun(() ->
                        System.out.println("DO final commits here"));
        future.get();


        CompletableFuture parser = CompletableFuture.supplyAsync(() -> "A")
                .thenApply(Integer::parseInt)
                .exceptionally(t -> {
                    t.printStackTrace();
                    return null;
                }).thenAcceptAsync(s -> {
                    System.out.println("RECIEVED: " + s); // this will still continue even if we threw an exception!
                });
        parser.get();


        CompletableFuture correctHandler = CompletableFuture.supplyAsync(() -> "1")
                .thenApply(Integer::parseInt)
                .handle((result, ex) -> { //gives us a way to handle possible exceptions and return default value
                    System.out.println("HANDLING " + result);
                    return "1";
                })
                .thenAcceptAsync(s -> {
                    System.out.println("CORRECT: " + s);
                });
        correctHandler.get();
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
