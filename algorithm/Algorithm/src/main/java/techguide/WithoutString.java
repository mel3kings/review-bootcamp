package techguide;

public class WithoutString {
    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have been removed (not case sensitive). You may assume that the remove string is length 1 or more. Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     *
     *
     * withoutString("Hello there", "llo") → "He there"
     * withoutString("Hello there", "e") → "Hllo thr"
     * withoutString("Hello there", "x") → "Hello there"
     * @param args
     */

    public static void main(String[] args) {
        System.out.println(new WithoutString().withoutString("Hello There", "e"));
    }

    public String withoutString(String base, String remove) {
        int removeIndex = base.toLowerCase().indexOf(remove.toLowerCase());
        if (removeIndex == -1) {
            return base;
        } else {
            return base.substring(0, removeIndex) +
                    withoutString(base.substring(removeIndex + remove.length()), remove);
        }
    }


}