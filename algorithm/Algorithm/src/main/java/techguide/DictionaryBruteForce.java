package techguide;

public class DictionaryBruteForce {


    /**
     * Brute force solution of Dictionary,
     * Sort
     * @param args
     */
    public static void main(String[] args) {
        DictionaryBruteForce d = new DictionaryBruteForce();
        String[] words = new String[]{"ax", "apple", "aaa", "bb", "banana", "zoo"};
        d.selectionSort(words);

        String find = "abbppplebananan";

        for (String w : words) {
            if (d.isSubsequence(find, w)) {
                System.out.println(w);
                break;
            }
        }

    }

    /**
     * Sort first DictionaryBruteForce by descending order
     *
     * @param word
     */
    public void selectionSort(String[] word) {
        for (int i = 0; i < word.length; i++) {
            for (int j = i + 1; j < word.length; j++) {
                if (word[i].length() < word[j].length()) {
                    String swap = word[i];
                    word[i] = word[j];
                    word[j] = swap;
                }
            }
        }
    }

    public boolean isSubsequence(String word, String sub) {
        char[] wordArr = word.toCharArray();
        char[] subArr = sub.toCharArray();

        int i = 0, j = 0;
        while (i < wordArr.length && j < subArr.length) {
            if (wordArr[i] == subArr[j]) {
                j++;
            }
            i++;
        }

        if (j == subArr.length) {
            return true;
        } else {
            return false;
        }
    }


}
