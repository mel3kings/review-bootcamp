def setAdjacentToOne(adj_row, adj_col, max_row, max_column, grid, bool_grid):
    if adj_col < max_column and adj_row < max_row:
        grid[adj_row][adj_col] = 1
        bool_grid[adj_row][adj_col] = False
    return grid

def minimumDays(rows, columns, grid):
    temp_grid = grid
    iterations = 0
    bool_grid = [[False for i in range(rows+1)] for j in range(columns+1)]
    for i in range(0, rows):
        for j in range(0, columns):
            if grid[i][j] == 1:
                temp_grid = setAdjacentToOne(i, j + 1, rows, columns, grid, bool_grid)
                temp_grid = setAdjacentToOne(i, j - 1, rows, columns, grid, bool_grid)
                temp_grid = setAdjacentToOne(i + 1, j, rows, columns, grid, bool_grid)
                temp_grid = setAdjacentToOne(i - 1, j, rows, columns, grid, bool_grid)
            iterations+=1
    print(iterations)
    return iterations
    # WRITE YOUR CODE HERE
    pass


minimumDays(4, 5, [[0, 1, 1, 0, 1],
                   [0, 1, 0, 1, 0],
                   [0, 0, 0, 0, 1],
                   [0, 1, 0, 0, 0]])
