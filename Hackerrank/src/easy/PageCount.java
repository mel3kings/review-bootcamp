package easy;

public class PageCount {

    /**
     * https://www.hackerrank.com/challenges/drawing-book/problem
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(pageCount(73201, 57075));
    }


    static int pageCount(int n, int p) {
        int endPage = n % 2 == 0 ? n : n - 1;
        int fromEnd = p % 2 == 0 ? (endPage - p) / 2 : (endPage - (p - 1)) / 2;
        int fromStart = p % 2 == 0 ? p / 2 : (p - 1) / 2;
        return fromEnd < fromStart ? fromEnd : fromStart;
    }
}
