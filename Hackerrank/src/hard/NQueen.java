package hard;

public class NQueen {
    static int counter = 0;

    public static void main(String[] args) {
        int n = 4;
        String[][] grid = new String[n][n];

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                grid[r][c] = ".";
            }
        }
        isRook(grid, 0, 0, n);
        printGrid(grid);
    }

    public static void isRook(String[][] grid, int startRow, int startCol, int max) {
        if (counter == 4) {
            System.out.println("DONE!!");
            printGrid(grid);
        }

        for (int r = 0; r < grid.length; r++) {
            for (int c = startCol; c < grid[startRow].length; c++) {
                if (isRookSafe(grid, r, c,max) && counter < max) {
                    grid[r][c] = "Q";
                    counter++;
                    isRook(grid, r, c, max);
                }
            }
        }
        counter = 0;
        grid[startRow][startCol] = ".";

    }

    public static boolean isRookSafe(String[][] grid, int r, int c, int max) {
        for (int i = r; i < max; i++) {
            if (isQueen(grid, i, c)) {
                return false;
            }
            if (isQueen(grid, r, i)) {
                return false;
            }

        }
        for (int i = r; i >= 0; i--) {
            if (isQueen(grid, i, c)) {
                return false;
            }
            if (isQueen(grid, r, i)) {
                return false;
            }
        }

        return true;
    }


    public static void printGrid(String[][] grid) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                System.out.print(grid[r][c]);
            }
            System.out.println("");
            System.out.println("");
        }
    }

    public static boolean isQueen(String[][] grid, int r, int c) {
        if (r < 0 || c < 0) {
            return false;
        }
        if (r > grid.length || c > grid[r].length) {
            return false;
        }
        if (grid[r][c].equals("Q")) {
            return true;
        }
        return false;
    }
}
