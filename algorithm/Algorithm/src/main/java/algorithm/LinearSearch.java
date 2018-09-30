package algorithm;

public class LinearSearch {

    public static void main(String[] args){
        int[] a = {3,5,79,13,789,12,6,8};
        int x = 12;
        System.out.println(recursiveSearch(a,x, 0));
    }

    public static int search(int[] a, int x){
        for(int i = 0; i< a.length; i++){
            if(a[i] == x){
                return i;
            }
        }
        return -1;
    }

    public static int recursiveSearch(int[] a, int x, int i){
        if(i > a.length){
            return -1;
        } else {
            if(a[i] == x){
                return i;
            } else {
              return recursiveSearch(a, x, ++i);
            }
        }
    }
}
