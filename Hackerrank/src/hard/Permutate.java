package hard;

import java.util.*;

public class Permutate {

    public static void main(String[] args) {
        permutate(new int[]{1,2,3,4});
    }


    static void permutate(int[] arr){
        Set<List<Integer>> setOfUnique = new HashSet<>();
        Set<List<Integer>> copyOfUnique = new HashSet<>();

        setOfUnique.add(Arrays.asList());
        copyOfUnique.add(Arrays.asList());
        for(int i = 0; i < arr.length; i++){
            int current = arr[i];
            for(List x : copyOfUnique){
                ArrayList<Integer> newList = new ArrayList<>(x);
                newList.add(current);
                System.out.println("new combination" + newList);
                setOfUnique.add(newList);
            }
            copyOfUnique = new HashSet<>(setOfUnique);
        }
        System.out.println(setOfUnique);
    }

}
