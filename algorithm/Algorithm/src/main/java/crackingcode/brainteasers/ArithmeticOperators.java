package crackingcode.brainteasers;

/**
 * Add arithmetic operators (plus, minus, times, divide)
 * to make the following expression true: 3 1 3 6 = 8
 * You can use any parentheses you’d like
 */
public class ArithmeticOperators {

    public static void main(String[] args){
        System.out.println("Solve for 3 1 3 6 = 8 using any arithmetic operation");
        // step 1 know that the constraint that the last constraint is 6:
        // so know the possible combinations of 6 that will equal 8;
        System.out.println("Addition: 2 + 6 = 8");
        System.out.println("Subtraction: 14 - 6 = 8");
        System.out.println("Division: 48 / 6 = 8");
        System.out.println("Multiplication: 1.33 * 6 = 8");


        //Step 2 notice that we have 3 1 3 left, so we just need to figure out
        // which of 2, 14, 48, 1.33 can we form based on 3,1,3
        // 48 and 14 is out of the question as even if add and multiply (3+1) * 3 = max is 12
        // so we only need 2 and 1.33, trying to solve for 2 with 3,1,3:

        System.out.println("Final Solution is ((3 + 1) /3 )* 6");

        // alternatively, we already know that (3+1) * (6/3)= 8 OR 4 * 2
        // problem was 6 was placed last, so the final solution is just moving around so that 6 is last

    }
}
