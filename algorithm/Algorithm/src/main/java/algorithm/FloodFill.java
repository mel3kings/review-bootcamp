package algorithm;

public class FloodFill {

    public static void main(String[] args) {
        int screen[][] =
                {
                        {3, 3, 3, 3, 3, 3, 1, 1},
                        {1, 1, 1, 1, 1, 3, 1, 1},
                        {1, 1, 1, 1, 1, 3, 1, 1},
                        {1, 2, 2, 2, 2, 3, 3, 3},
                        {1, 1, 1, 2, 2, 1, 1, 1},
                        {1, 1, 1, 2, 2, 2, 2, 1},
                        {1, 1, 1, 1, 1, 4, 1, 1},
                        {1, 1, 1, 1, 1, 4, 4, 1},
                };
        FloodFill f = new FloodFill();
        f.floodFill(screen, 0, 1);
        System.out.println(connected);

    }

    private static int connected = 0;
    private static int visited = 999;
    private static int MAX_HEIGHT = 7, MAX_WIDTH = 7;
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
    public void floodFill(int[][] screen, int x, int y) {
        if (x > MAX_HEIGHT || y > MAX_WIDTH || x < 0 || y < 0) {
            return;
        }
        if (FOUND == null) {
            FOUND = screen[x][y];
        }

        if (screen[x][y] == FOUND) {
            screen[x][y] = visited;
            connected++;
            floodFill(screen, x + 1, y);
            floodFill(screen, x - 1, y);
            floodFill(screen, x, y + 1);
            floodFill(screen, x, y - 1);
        }


    }

}
