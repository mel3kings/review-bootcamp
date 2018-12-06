package crackingcode.stringsandarrays;

public class SubstringChecker {

    public static void main(String[] args){
        String wordCheck = "waterbottle";
        assert(isSubstring(wordCheck, "erbottlewat"));
    }

    public static boolean isSubstring(String actualWord, String checkWord){
        String concatenated = actualWord + actualWord;
        return concatenated.contains(checkWord);
    }
}

