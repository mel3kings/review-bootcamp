package crackingcode.stringsandarrays;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Future;

public class ReverseString {
    public static void main(String[] args) throws Exception{
        String toReverse = "Melchor";

        CompletableFuture<String> reverse = CompletableFuture.completedFuture(reverse(toReverse))
                .thenApply(ReverseString::reverseEight).exceptionally(throwable ->  "");
        String result = reverse.get();
        System.out.println(result);
        //  System.out.println(reverse(toReverse));
        // System.out.println(reverseEight(toReverse));
    }

    private static String test() {
        return "Test";
    }

    private static String test2(String r) {
        return "Test";
    }



    private static String reverse(String reverseMe) {
        char[] array = reverseMe.toCharArray();
        String returnResponse = "";
        for (int i = array.length - 1; i >= 0; i--) {
            returnResponse += array[i];
        }
        return returnResponse;
    }

    /**
     * performance hit on mapping object,
     * using parallel hence need combiner, otherwise will not be invoked
     *
     * @param reverse to be reversed
     * @return reversed String
     */
    private static String reverseEight(String reverse) {
        return reverse.chars().parallel()
                .mapToObj(c -> (char) c)
                .collect(StringBuilder::new,
                        (response, element) -> response.insert(0, element),
                        (response1, response2) -> response1.insert(0, response2)).toString();
    }
}
