package algorithm.datastructures;

import java.util.List;
import java.util.stream.Collectors;

public class Stack {
    private String[] data;
    private int top;

    public Stack(int maxSize){
        data = new String[maxSize];
        top = -1; // at this point we do not have anything yet
    }

    public void push(String value){
        top++; //increment top to signify newest data
        data[top] = value;
    }

    public String pop(){
        String value = data[top];
        top--; // decrement top
        return value;
    }

    // do not increment o decrement, just check if the value is there
    public String peak(){
        return data[top];
    }

    public static void main(String[] args){
        Stack mailStack = new Stack(5);
        mailStack.push("Electricity Bills");
        mailStack.push("Rental Bills");
        mailStack.push("Water Bills");
        mailStack.push("Love Letter");
        System.out.println(mailStack.pop()); // Love Letter
        System.out.println(mailStack.pop()); // Water Bills
        mailStack.push("Government Letter");
        System.out.println(mailStack.peak()); // Government Bills
        System.out.println(mailStack.pop()); // Government Bills
        System.out.println(mailStack.pop()); // Rental Bills

        //Traversing a word from the end: Hello -> should print out o l l e H
        java.util.Stack<Character> characters = new java.util.Stack<>();
        String word = "Hello";
        List<Character> list = word.chars() // convert string to a int stream (no direct stream call)
                .mapToObj(intValue-> (char) intValue) // convert each int value back to character
                .collect(Collectors.toList()); // collect them to a list agvain
        characters.addAll(list);
        while(!characters.isEmpty()){
            System.out.println(characters.pop());
        }
    }




}
