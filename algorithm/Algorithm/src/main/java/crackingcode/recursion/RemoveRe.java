package crackingcode.recursion;

public class RemoveRe {

    public static void main(String[] args) {
        System.out.println(remove("Hello There", "e"));
    }

    public static String remove(String word, String sub) {
        int index = word.indexOf(sub);
        if (index == -1) {
            return word;
        }
        int end = index + sub.length();
        return word.substring(0, index) + remove(word.substring(end), sub);
    }
}
