package algorithm;

import java.util.Arrays;

/**
 * Divide the array into two parts sort and unsorted
 * Iterate over the array, and pass the element to the sorted portion, sorting them along the way
 */
public class InsertionSort {
    public static void main(String[] args){
        int[] test = {8,10,6, 7};
        Arrays.stream(insertionSort(test)).forEach(System.out::println);
        // 8,10,6 element 6
        // 8, 10,10
        // 8, 8, 10
    }
    public static int[] insertionSort(int[] a){
        for(int i = 1; i < a.length; i++){
            int element = a[i];
            int j = i-1;
            while(j >=0 && a[j] > element){
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = element;
        }
        return a;
    }


}
