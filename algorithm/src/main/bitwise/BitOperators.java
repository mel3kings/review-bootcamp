package bitwise;

public class BitOperators {
    public static void main(String[] args){
        System.out.println("&");
        System.out.println(false & false);
        System.out.println(false & true);
        System.out.println(true & false);
        System.out.println(true & true);

        System.out.println("|");
        System.out.println(false | false);
        System.out.println(false | true);
        System.out.println(true | false);
        System.out.println(true | true);

        System.out.println("^");
        System.out.println(false ^ false);
        System.out.println(false ^ true);
        System.out.println(true ^ false);
        System.out.println(true ^ true);

        System.out.println("! or ~");
        System.out.println(!false);
        System.out.println(!true);

        System.out.println(">> or <<");
        System.out.println(1<<7);
        System.out.println(1>>7);


    }
}
