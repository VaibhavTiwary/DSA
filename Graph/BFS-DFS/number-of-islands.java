// Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the 
// number of islands.

// An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
// You may assume all four edges of the grid are all surrounded by water.

 

// Example 1:

// Input: grid = [
//   ["1","1","1","1","0"],
//   ["1","1","0","1","0"],
//   ["1","1","0","0","0"],
//   ["0","0","0","0","0"]
// ]
// Output: 1
//..............................
// "Both have same time complexity, but for large connected regions, I prefer BFS to avoid stack overflow. 
// If the grid is small or recursion is allowed, DFS is simpler and shorter to write."

//BFS Solution
// TC and SC- O(m*n)

class Pair{
    int first;
    int second;

    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}



class Solution {
    public int numIslands(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        int count = 0;

        for(int row = 0; row < m; row++){
            for(int col = 0; col < n; col++){
                if(vis[row][col] == 0 && grid[row][col] == '1'){
                    count++;
                    bfs(row, col, vis, grid);
                }
            }
        }
        return count;
    }

    void bfs(int ro, int co, int[][] vis, char[][] grid){
        vis[ro][co] = 1;
        Queue <Pair> queue = new LinkedList<>();
        queue.add(new Pair(ro, co));

        int m = grid.length;
        int n = grid[0].length;

        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};
        while(!queue.isEmpty()){
            int row = queue.peek().first;
            int col = queue.peek().second;
            queue.remove();

            for(int i = 0; i < 4; i++){
                int newrow = row + dRow[i];
                int newcol = col + dCol[i];
                if(newrow >= 0 && newrow < m && newcol >= 0 && newcol < n && vis[newrow][newcol] == 0 && grid[newrow][newcol] == '1'){
                    queue.add(new Pair(newrow, newcol));
                    vis[newrow][newcol] = 1;
                }
            }
        }
    }
}


//DFS
// "In the worst case, if the island covers the entire grid, the recursion depth can be m * n, which risks stack overflow."
class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n]; // Visited array
        int count = 0;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (!vis[row][col] && grid[row][col] == '1') {
                    count++;
                    dfs(grid, vis, row, col);
                }
            }
        }
        return count;
    }

    void dfs(char[][] grid, boolean[][] vis, int row, int col) {
        int m = grid.length;
        int n = grid[0].length;

        // Boundary check and visited/water check
        if (row < 0 || row >= m || col < 0 || col >= n || vis[row][col] || grid[row][col] == '0') {
            return;
        }

        // Mark current cell as visited
        vis[row][col] = true;

        // Explore all 4 directions
        dfs(grid, vis, row - 1, col); // Up
        dfs(grid, vis, row + 1, col); // Down
        dfs(grid, vis, row, col - 1); // Left
        dfs(grid, vis, row, col + 1); // Right
    }
}
