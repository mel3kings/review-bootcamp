package algorithm.examples;

import java.util.Arrays;

public class Merger {
    public static void main(String[] args){
        int[] unsorted = {1,3,4,125,56,7,123};
        sort(unsorted, 0, unsorted.length -1);
        Arrays.stream(unsorted).forEach(System.out::println);
    }

    public static void sort(int[] unsorted, int start, int end){
        int mid = (start + end)/2;
        if(start < end){
            sort(unsorted, start, mid);
            sort(unsorted, mid+1, end);
            merge(unsorted, start, mid, end);
        }
    }

    public static void merge(int[] unsorted,int start,int mid,int end){
        int leftSlot =  start;
        int rightSlot =  mid +1;
        int k = 0;
        int[] sorted = new int[end - start +1];
        while(leftSlot <= mid && rightSlot <=end){
            if(unsorted[leftSlot] < unsorted[rightSlot]){
                sorted[k] = unsorted[leftSlot];
                leftSlot ++;
            }else{
                sorted[k] = unsorted[rightSlot];
                rightSlot ++;
            }
            k++;
        }

        while(leftSlot <= mid){
            sorted[k] = unsorted[leftSlot];
            leftSlot++;
            k++;
        }
        while(rightSlot <= end){
            sorted[k] = unsorted[rightSlot];
            rightSlot++;
            k++;
        }

        for(int i = 0; i < sorted.length; i++){
            unsorted[start + i] = sorted[i];
        }
    }
}
