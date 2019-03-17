package medium;

import java.util.HashMap;

public class MagicSquare {
    public static void main(String[] args) {
        int[][] square = new int[][]{
                {8, 3, 4},
                {1, 5, 9},
                {6, 7, 2}
        };

        System.out.println(isFormingMagicSquare(square));
    }

    static boolean isFormingMagicSquare(int[][] s) {
        HashMap<Integer, Integer> magicNumber = new HashMap<>();
        HashMap<Integer, Integer> duplicateMaps = new HashMap<>();
        int down = 0;
        int line = 0;
        int diagonal;
        for (int i = 0; i < s.length; i++) {
            down += s[0][i] + s[1][i] + s[2][i];
            for (int j = 0; j < s[i].length; j++) {
                line += s[i][j];
                duplicateMaps.compute(s[i][j], (k, v) -> v == null ? 1 : v + 1);
            }
            magicNumber.compute(down, (k, v) -> v == null ? 1 : v + 1);
            magicNumber.compute(line, (k, v) -> v == null ? 1 : v + 1);
            line = 0;
            down = 0;
        }
        diagonal = s[0][0] + s[1][1] + s[2][2];
        magicNumber.compute(diagonal, (k, v) -> v == null ? 1 : v + 1);
        diagonal = s[2][0] + s[1][1] + s[0][2];
        magicNumber.compute(diagonal, (k, v) -> v == null ? 1 : v + 1);
        return magicNumber.size() == 1 && duplicateMaps.values().stream().allMatch(x -> x == 1);
    }
}
