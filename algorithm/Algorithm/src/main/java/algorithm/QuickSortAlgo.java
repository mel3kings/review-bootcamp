package algorithm;

import java.util.Arrays;

public class QuickSortAlgo {
    public static void main(String[] args){
        int[] test = {6,8,7,2,4,3,5};
        quickSort(test, 0, test.length-1);
        Arrays.stream(test).forEach(System.out::println);
    }

    public static void quickSort(int[] array, int start, int end){
        if(start < end){
            int partitionPoint = partition(array, start, end);
            quickSort(array, start , partitionPoint -1);
            quickSort(array, partitionPoint +1 , end);

        }
    }

    public static int partition(int[] array, int start, int end){
        int partition = array[end];
        int i = start -1;
        for(int j = start; j <= end-1; j++){
            if(array[j]<=  partition){
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int correctPivot = i+1;
        int temp = array[correctPivot];
        array[correctPivot] = array[end];
        array[end] = temp;
        return correctPivot;

    }
}
