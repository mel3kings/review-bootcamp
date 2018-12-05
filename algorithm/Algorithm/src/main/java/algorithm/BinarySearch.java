package algorithm;

/**
 * Search the value by checking if the value
 * is in the bigger half or smaller half, keep dividing the array
 */
public class BinarySearch {
    public static void main(String[] args) {
        int search[] = {1, 22, 33, 44, 56, 67, 78, 89, 90, 101};
        System.out.println(binarySearch(search, 22));
        System.out.println(recursiveBinary(search, 101, 0, search.length -1));
    }

    public static int binarySearch(int[] search, int findMe) {
        int tail = 0;
        int head = search.length - 1;
        while (tail <= head) {
            int halfway = (tail + head) / 2;
            if (search[halfway] == findMe) {
                return halfway;
            } else if (search[halfway] > findMe) {
                head = halfway - 1;
            } else {
                tail = halfway + 1;
            }
        }
        return -1;
    }

    public static int recursiveBinary(int[] search, int find, int tail, int head) {
        int halfway = (tail + head) / 2;
        if (tail > head) {
            return -1;
        } else {
            if (search[halfway] == find) {
                return halfway;
            } else if (search[halfway] > find) {
                return recursiveBinary(search, find, tail, halfway -1);
            }else {
                return recursiveBinary(search, find, halfway + 1, head);
            }
        }
    }
}
