package util;

import java.util.Random;

public class Utils {
    /**
     * Generete random number
     *
     * @return
     */
    public static String randomLetter() {
        Random r = new Random();
        char c = (char) (r.nextInt(26) + 'a');
        return String.valueOf(c);
    }

    /**
     * Generate random number
     *
     * @return
     */
    public static int randomNumber() {
        int max = 20;
        int min = 1;
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }


}
