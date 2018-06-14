package algorithm;

import java.util.Arrays;

/**
 * Keeps breaking the array into two parts until base, then merges them in sorted order
 */
public class MergeSortAlgo {
    public static void main(String[] args){
        int[] test = {12,7,5,0,9,2};
        MergeSortAlgo al = new MergeSortAlgo();
        al.sort(test, 0, test.length -1);
        System.out.println("DONE");
        Arrays.stream(test).forEach(System.out::println);


    }

    public void sort(int[] A, int start, int end){
        if(start < end){
            int mid = (start + end) /2;
            sort(A, start, mid);
            sort(A, mid +1, end);
            merge(A, start, mid, end);
        }
    }

    public void merge(int[] A, int start, int mid, int end) {
      int [] temp = new int[end - start + 1];
      int leftSlot = start;
      int rightSlot = mid + 1;
      int k = 0;

      while(leftSlot <= mid && rightSlot <= end){
          if(A[leftSlot] < A[rightSlot]){
              temp[k] = A[leftSlot];
              leftSlot++;
          } else {
            temp[k] = A[rightSlot];
            rightSlot++;
          }
          k++;
      }

      //right side sorted
      if(leftSlot <= mid){
            while(leftSlot <=mid){
                temp[k] = A[leftSlot];
                leftSlot++;
                k++;
            }
      } else if(rightSlot >= end){
          while(rightSlot <= end){
              temp[k] = A[rightSlot];
              rightSlot++;
              k++;
          }
      }

      for(int i =0; i< temp.length; i++){
          A[start+i] = temp[i];
      }
    }
}
