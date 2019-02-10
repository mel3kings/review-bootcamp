package hard;

public class GetConsecutive {

    /**
     * Given a number e.g 15, find all count and print all consecutive numbers equal to 15
     * We are creating a moving tail and start and adding them as sum checking if they are equal to the sum
     * if they exceed the sum we move the tail and see from there.
     * Tail      Start
     * v         v
     * 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
     */
    public static long getConsecutive(long num) {
        long mid = (num / 2) + 1;
        long start = 0,sum = 0, tail = 0, counter = 0;
        while (start <= mid) {
            sum += start;
            while (sum >= num && tail != start) {
                if (sum == num) {
                    counter++;
                }
                tail++;
                sum -= tail;
            }
            start++;
        }
        return counter;
    }

    public static void main(String[] args) {
        System.out.println(getConsecutive(15));
    }
}
