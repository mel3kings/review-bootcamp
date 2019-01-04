package crackingcode.review;

import java.util.List;
import java.util.Stack;

public class FindObstacle {

    public static void main(String[] args) {
        int screen[][] =
                {
                        {1, 1, 1, 1},
                        {0, 1, 1, 1},
                        {0, 1, 0, 1},
                        {1, 1, 9, 1},
                        {0, 0, 1, 1}
                };
        FindObstacle f = new FindObstacle();
        f.findObstacle(screen, 0, 0);
        System.out.println(connected);

    }

    private static int connected = 0;
    private static int visited = 999;
    private static int OBSTACLE = 9;

    private static int MAX_HEIGHT = 0, MAX_WIDTH = 0;
    private Integer FOUND = null;

    /**
     * Limitation: we need to change the visited to a different number
     * so it does not become an infinite loop, we would also
     * need to make a copy of the array to retain original
     *
     * @param screen
     * @param x
     * @param y
     */
    public void findObstacle(int[][] screen, int x, int y) {
        if (x > MAX_HEIGHT || y > MAX_WIDTH || x < 0 || y < 0) {
            return;
        }
        if (FOUND == null) {
            FOUND = screen[x][y];
        }
        if (screen[x][y] == OBSTACLE) {
            return;
        } else if (screen[x][y] == FOUND) {
            screen[x][y] = visited;
            connected++;
            findObstacle(screen, x + 1, y);
            findObstacle(screen, x - 1, y);
            findObstacle(screen, x, y + 1);
            findObstacle(screen, x, y - 1);
        }
    }

    int removeObstacle(int numRows, int numColumns, List<List<Integer>> lot) {
        Stack<List<Integer>> map = new Stack<>();
        MAX_HEIGHT = numRows - 1;
        MAX_WIDTH = numColumns - 1;
        int[][] lotArray = new int[numRows][numColumns];
        for (int i = 0; i < lot.size(); i++) {
            List<Integer> two = lot.get(i);
            for (int j = 0; j < two.size(); j++) {
                lotArray[i][j] = two.get(j);
            }
        }

        findObstacle(lotArray, 0, 0);
        return connected;
    }

}
