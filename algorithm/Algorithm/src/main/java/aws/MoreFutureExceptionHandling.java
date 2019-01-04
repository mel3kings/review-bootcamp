package aws;

import java.util.concurrent.CompletableFuture;

public class MoreFutureExceptionHandling {

    public static void main(String[] arg) {
        MoreFutureExceptionHandling f = new MoreFutureExceptionHandling();
        try {
            System.out.println(f.ask().get());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        CompletableFuture parser = CompletableFuture.supplyAsync(() -> "1")
                .thenApply(Integer::parseInt)
                .thenAcceptAsync(s -> {
                    System.out.println("RECIEVED: " + s);
                });

        boolean t = parser.completeExceptionally(new RuntimeException("ASD"));
        System.out.println(t);

        try {
            int test = MoreFutureExceptionHandling.converter("12A3").get();
            int second = MoreFutureExceptionHandling.converter("12B3").thenApply(s -> s + 1).get();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try {
           CompletableFuture<Integer> test = (MoreFutureExceptionHandling.converter("AAAA"))
                    .whenComplete((result, ex) -> ex.printStackTrace());
           test.get();
        } catch (Exception ex) {

        }
    }

    public CompletableFuture<String> ask() {
        CompletableFuture<String> future = new CompletableFuture<>();
        future.complete("42");
        return future;
    }

    public static CompletableFuture<Integer> converter(String convertMe) {
        CompletableFuture<Integer> future = new CompletableFuture<>();
        try {
            future.complete(Integer.parseInt(convertMe));
        } catch (Exception ex) {
            future.completeExceptionally(ex);
        }
        return future;
    }
}
