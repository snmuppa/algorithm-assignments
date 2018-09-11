// Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
// An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
// You may assume all four edges of the grid are all surrounded by water.
//
// Input:
// 11110
// 11010
// 11000
// 00000
// Output: 1
//
// Input:
// 11000
// 11000
// 00100
// 00011
// 
// Output: 3
//

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null) {
            return 0;
        }
        
        int rowCount = grid.length;
        int columnCount = grid[0].length;
        
        if(rowCount == 0 || columnCount ==0) {
            return 0;
        }
        
        int result = 0;
        
        boolean visited[][] = new boolean[rowCount][columnCount];
        
        for(int row = 0; row < rowCount; row++) { // traverse over all the elements
            for(int column = 0; column < columnCount; column++) {
                if(!visited[row][column]) {
                    if(grid[row][column] == '0' ) {
                        visited[row][column] = true;
                    } else if(grid[row][column] == '1') {
                        dfs(row, column, rowCount, columnCount, visited, grid);
                        result++;
                    }
                }
            }
        }
        
        return result;
    }
    
    /**
    * DFS on the elements with 1, to traverse the strongly connected components in an undirected graph
    */
    private void dfs(int row, int column, int rowCount, int columnCount, boolean[][] visited, char[][] grid) {
        if(visited[row][column]) {
            return;
        }
        
        if(grid[row][column] == '0') { // ignore 0's by marking them as visited
            visited[row][column] = true;
            return;
        }
        
        visited[row][column] = true;
        
        int currentLocation[] = { row, column };
        
        for(int[] location : getNeighbors(rowCount, columnCount, currentLocation)) {
            dfs(location[0], location[1], rowCount, columnCount, visited, grid);
        }
    }
    
    /**
    * Gets the neighbors of a given element in a 2D array.
    */
    private List<int[]> getNeighbors(int rowCount, int columnCount, int[] currentElementLocation) {
        int rowOffSets[] = { -1, 0, 1, 0 };
        int columnOffSets[] = {0, -1, 0, 1 };
        
        List<int[]> neighborCells = new ArrayList<>(); 
        
        for(int i = 0; i < 4; i++) {
            if(isSafe(rowOffSets[i], columnOffSets[i], currentElementLocation[0], currentElementLocation[1], rowCount, columnCount)) {
                int[] neighborLocation = {currentElementLocation[0] + rowOffSets[i], currentElementLocation[1] + columnOffSets[i]};
                neighborCells.add(neighborLocation);
            }
        }
        
        return neighborCells;
    }
    
    private boolean isSafe(int rowOffSet, int columnOffSet, int currentRow, int currentColumn, int rowCount, int columnCount) {
        boolean isSafe = true;
        
        if(isSafe && (rowOffSet + currentRow) > rowCount - 1) {
            isSafe = false;
        } 
        
        if(isSafe && (rowOffSet + currentRow) < 0) {
            isSafe = false;
        }
        
        if(isSafe && (columnOffSet + currentColumn) > columnCount - 1) {
            isSafe = false;
        } 
        
        if(isSafe && (columnOffSet + currentColumn) < 0) {
            isSafe = false;
        } 
        
        return isSafe;
    }
}
