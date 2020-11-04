package easy;

import java.util.*;

public class CleanFloodFill {
    public static void main(String[] args){
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
        CleanFloodFill cf = new CleanFloodFill();
        screen = cf.floodFill(screen, 1,1,99);
        System.out.println(Arrays.deepToString(screen));
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image.length == 0 || image[0].length == 0) {
            return image;
        }
        int originalColor = image[sr][sc];
        if (newColor == originalColor) {
            return image;
        }
        image = recurseFill(image, sr, sc, newColor, originalColor);
        return image;
    }

    public int[][] recurseFill(int[][] image, int sr, int sc, int newColor, int originalColor) {
        if (sr < 0 || sc < 0) {
            return image;
        }
        if (sr >= image.length || sc >= image[sr].length) {
            return image;
        }
        int[] x = new int[]{-1, 0, 1, 0};
        int[] y = new int[]{0, 1, 0, -1};
        if (image[sr][sc] == originalColor) {
            image[sr][sc] = newColor;
            for (int i = 0; i < 4; i++) {
                image = recurseFill(image, sr + x[i], sc + y[i], newColor, originalColor);
            }
        }
        return image;
    }
}
