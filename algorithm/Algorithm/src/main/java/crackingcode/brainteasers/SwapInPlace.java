package crackingcode.brainteasers;

public class SwapInPlace {

    public static void main(String[] args){
        swap(4, 20);
    }

    public static void swap(int a, int b){
        a = b - a;
        b = b - a;
        a = a + b;

        System.out.println(a + " " + b);
    }
}
