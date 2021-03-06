package medium;

import java.util.*;

public class MaxSquare {

    int[][] dp;

    public int maximalSquare(char[][] matrix) {
        int currMax = 0;
        dp = new int[matrix.length][matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            dp[row][0] = Character.getNumericValue(matrix[row][0]);
            currMax = Math.max(currMax, dp[row][0]);
            for (int col = 0; col < matrix[row].length; col++) {
                dp[0][col] = Character.getNumericValue(matrix[0][col]);
                currMax = Math.max(currMax, dp[0][col]);
            }
        }

        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[row].length; col++) {
                int curr = Character.getNumericValue(matrix[row][col]);
                if (curr == 0) {
                    dp[row][col] = 0;
                    continue;
                }
                int left = dp[row - 1][col];
                int top = dp[row][col - 1];
                int diagonal = dp[row - 1][col - 1];
                if (left == 0 || top == 0 || diagonal == 0) {
                    dp[row][col] = curr;
                    currMax = Math.max(currMax, dp[row][col]);
                    continue;
                }

                if (top == left && left == diagonal) {
                    dp[row][col] = top + 1;
                } else {
                    dp[row][col] = Math.max(diagonal, Math.max(top, left));
                }

                currMax = Math.max(currMax, dp[row][col]);

            }
        }
        System.out.println(Arrays.deepToString(dp));

        return currMax * currMax;
    }


}


//[["1","1","1","1","0"],
// ["1","1","1","1","1"],
// ["1","1","1","1","1"],
// ["1","0","0","1","0"]]
//
//
//
// [["1","1","1","1","0"],
// ["1","0","1","1","1"],
// ["1","1","1","1","1"],
// ["1","0","0","1","0"]]
//
//
// [["1","1", "0"],
//  ["1","1", "0"]]
//
//
//[["1","1", "0"]
//,["1","1","0"]]
//
//
//[["1","1", "0"],["1","1","0"]]
//[["0","1"],["1","0"]]
//[["1"]]
//[["0"]]
//[["0","1"],["1","0"]]
//
//
//[["1","1","1","1","0"],
// ["1","1","1","1","1"],
// ["1","1","1","1","1"],
// ["1","0","0","1","0"]]
//
//
//1 1 1 1 0
//1 2 2 2 1  if left and top > 0 then plus one else check if 1 or 0 if edge do 1
//1 2 3 3 1
//1 0 0 1	0
//
//[[1, 1, 1, 1, 0], [1, 2, 2, 2, 1], [1, 2, 3, 3, 1], [1, 0, 0, 1, 0]]
//
//[[1, 1, 1, 1, 0],
// [1, 2, 2, 2, 1],
// [1, 2, 3, 3, 3],
// [1, 0, 0, 1, 0]]
//
//
//
//[["1","1","1","1","1"],["1","1","1","1","1"],["1","1","1","1","1"],["1","1","1","1","1"]]
//[["1","1","1","1","1"],["1","1","0","1","1"],["1","1","1","1","1"],["1","1","1","1","1"]]
//[["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
//[["1","1","1","1","0"],["1","1","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
//[["1","1", "0"],["1","1","0"]]
//[["0","1"],["1","0"]]
//[["1"]]
//[["0"]]
//[["0","1"],["1","0"]]
//[["0","0"],["0","0"]]
//[["1","1","1","1","1","1","1","1","1","1"],["1","1","1","1","1","1","1","1","1","1"],["1","1","1","1","1","1","1","1","1","1"],["1","1","1","1","1","1","1","1","1","1"],["1","1","1","1","1","1","1","1","1","1"],["1","1","1","1","1","1","1","1","1","1"],["1","1","1","1","1","1","1","1","1","1"],["1","1","1","1","1","1","1","1","1","1"],["1","1","1","1","1","1","1","1","1","1"]]
//[["1","1","1","1","1","1","1","1","1","1"],["1","1","0","1","1","1","1","1","1","1"],["1","0","1","1","1","1","1","1","1","1"],["1","1","1","1","1","1","0","1","1","1"],["1","1","1","1","1","1","1","1","1","1"],["1","1","0","1","1","1","1","1","1","1"],["0","1","1","1","1","1","0","1","1","1"],["1","1","1","1","1","1","1","1","1","1"],["1","1","1","1","1","1","1","1","1","0"]]
//
//
//[["1","1","1","1","1"],
// ["1","1","0","1","1"],
// ["1","1","1","1","1"],
// ["1","1","1","1","1"]]
//
//[["1","1","1","1","1"],
//["1","1","1","1","1"],
//["1","1","1","1","1"],
//["1","1","1","1","1"]]
//
//[[1, 1, 1, 1, 1],
// [1, 2, 2, 2, 2],
// [1, 1, 1, 1, 1],
// [1, 2, 1, 2, 1]]