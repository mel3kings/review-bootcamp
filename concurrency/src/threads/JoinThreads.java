package threads;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.IntStream;

public class JoinThreads {
    public static void main(String[] args){
        // change maxRange to see difference in algorithm speed
        int maxRange = 100000;
        int[] unsorted = IntStream.range(1,maxRange).map(range -> new Random().nextInt(10000)).toArray();
        Thread merger = new MergerSort(Arrays.copyOf(unsorted, unsorted.length));
        Thread insertion = new InsertionSort(Arrays.copyOf(unsorted, unsorted.length));

        merger.start();
        insertion.start();
        try{
            merger.join();
            insertion.join();
            System.out.println("All Sorting algo  done");
        }catch(InterruptedException ie){
            ie.printStackTrace();
        }
    }
}

class InsertionSort extends Thread{
    private int[] unsorted;

    public InsertionSort(int[] unsorted){
        this.unsorted = unsorted;
    }

    @Override
    public void run(){
        long start = System.currentTimeMillis();
        sort(unsorted);
        long end = System.currentTimeMillis() - start;
        System.out.println("INSERTION DONE in " + end + "ms");
    }
    public static void sort(int[] unsorted){
        for(int i = 1; i< unsorted.length;i++){
            int element = unsorted[i];
            int j = i-1;
            while(j >= 0 && unsorted[j] < element){
                unsorted[j+1] = unsorted[j];
                j--;
            }
            unsorted[j+1] = element;
        }

    }
}


class MergerSort extends Thread{
    private int[] unsorted;


    public MergerSort(int[] unsorted){
        this.unsorted = unsorted;
    }
    @Override
    public void run(){
        long start = System.currentTimeMillis();
        sort(unsorted, 0, unsorted.length -1);
        long end = System.currentTimeMillis() - start;
        System.out.println("MERGE DONE in " + end + "ms");


    }

    private void sort(int[] unsorted, int start, int end){
        int mid = (start + end) /2;
        if(start < end){
            sort(unsorted, start, mid);
            sort(unsorted, mid+1, end);
            merge(unsorted, start, mid, end);
        }
    }

    private void merge(int[] unsorted, int start, int mid, int end){
        int leftSlot = start;
        int rightSlot =  mid +1;
        int k = 0;
        int[] sorted = new int [end - start +1];
        while(leftSlot <= mid && rightSlot <= end){
            if(unsorted[leftSlot] < unsorted[rightSlot]){
                sorted[k] = unsorted[leftSlot];
                leftSlot++;
            }else{
                sorted[k] = unsorted[rightSlot];
                rightSlot++;
            }
            k++;
        }

        while(leftSlot <= mid){
            sorted[k] = unsorted[leftSlot];
            leftSlot++;
            k++;
        }
        while(rightSlot <= end){
            sorted[k] =  unsorted[rightSlot];
            rightSlot++;
            k++;
        }

        for(int i = 0; i < sorted.length; i++){
            unsorted[start + i] = sorted[i];
        }
    }

}
