package techguide;

public class WithSubString {

    /**
     * Given two words check if the second string is in subsequence of the first one
     * ie - > HelBBBBlo, Hello = true
     * @param args
     */
    public static void main(String[] args) {
        WithSubString test = new WithSubString();
        System.out.println(test.isSubString("HelBBBBlo", "Hello"));
        System.out.println(test.isSubString("abppplee", "apple"));
        System.out.println(test.isSubString("abppplee", "bale"));
    }

    public boolean isSubString(String word, String sub) {
        if (sub.length() > word.length()) {
            return false;
        }
        char[] wordArray = word.toCharArray();
        char[] subArray = sub.toCharArray();

        int wordCounter = 0;
        int matchCounter = 0;

        while (matchCounter < subArray.length && wordCounter < wordArray.length) {
            if (wordArray[wordCounter] == subArray[matchCounter]) {
                matchCounter++;
            }
            wordCounter++;

        }
        if (matchCounter == subArray.length) {
            return true;
        } else {
            return false;
        }

    }
}
