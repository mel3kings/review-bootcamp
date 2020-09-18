package review;

import java.util.*;

/**
 * https://leetcode.com/problems/rotting-oranges/
 */
public class OrangesRotting {
    private int count = 0;

    public int OrangesRotting(int[][] grid) {
        LinkedList<Point> startingPoints = new LinkedList<Point>();
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[r].length; c ++){
                if(grid[r][c] == 2){
                    startingPoints.offer(new Point(r, c));
                }
            }
        }
        BFS(grid, startingPoints);
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[r].length; c ++){
                if(grid[r][c] == 1){
                    return -1;
                }
            }
        }
        return count;
    }

    public void BFS(int[][] grid, LinkedList<Point> points){
        LinkedList<Point> nextSet = new LinkedList<Point>();

        while(!points.isEmpty()) {
            Point currentPoint = points.poll();
            int row = currentPoint.row;
            int column = currentPoint.column;
            grid[row][column] = 3;
            setAdjacent(grid, nextSet, row, column) ;
        }
        if(!nextSet.isEmpty()){
            count++;
            BFS(grid, nextSet);

        }
    }


    public void setAdjacent(int[][] grid, LinkedList<Point> points, int row, int column){
        if(row-1 >= 0 && grid[row-1][column] == 1){
            grid[row-1][column] = 2;
            points.offer(new Point(row-1, column));
        }
        if(row +1 < grid.length && grid[row+1][column] == 1){
            grid[row+1][column] = 2;
            points.offer(new Point(row+1, column));
        }
        if(column-1 >= 0  && grid[row][column-1] == 1){
            grid[row][column-1] = 2;
            points.offer(new Point(row, column-1));
        }
        if(column+1 < grid[0].length&& grid[row][column+1] == 1){
            grid[row][column+1] = 2;
            points.offer(new Point(row, column+1));
        }
    }

    class Point{
        int row;
        int column;
        public Point(int row, int column){
            this.row = row;
            this.column = column;
        }
    }
}
