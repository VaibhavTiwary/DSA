// Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right,
//  which minimizes the sum of all numbers along its path.

// Note: You can only move either down or right at any point in time.

// Example 1:

// Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
// Output: 7
// Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.


//Recursion
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        return helper(grid, 0, 0, m, n);
    }

    private int helper(int[][] grid, int i, int j, int m, int n) {
        // Out of bounds
        if (i >= m || j >= n) {
            return Integer.MAX_VALUE;
        }

        // Destination reached
        if (i == m - 1 && j == n - 1) {
            return grid[i][j];
        }

        // Recursive calls: move right and down
        int right = helper(grid, i, j + 1, m, n);
        int down = helper(grid, i + 1, j, m, n);

        return grid[i][j] + Math.min(right, down);
    }
}


//Memoization
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] memo = new int[m][n];

        // Fill memo with -1 to indicate unvisited
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }

        return dfs(grid, 0, 0, memo);
    }

    private int dfs(int[][] grid, int i, int j, int[][] memo) {
        int m = grid.length;
        int n = grid[0].length;

        // Out of bounds
        if (i >= m || j >= n) {
            return Integer.MAX_VALUE;
        }

        // Destination cell
        if (i == m - 1 && j == n - 1) {
            return grid[i][j];
        }

        // Return memoized result
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        // Explore right and down
        int right = dfs(grid, i, j + 1, memo);
        int down = dfs(grid, i + 1, j, memo);

        // Store result
        memo[i][j] = grid[i][j] + Math.min(right, down);
        return memo[i][j];
    }
}


//Bottom Up
//Filling first row and column with cumulative sum as there is only 1 wayto reach there by 
// travelling through their back so just add orev ones

// and then for other cells , find min of top and left and then add with the cur cell


class Solution {
    public int minPathSum(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        for(int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        
        for(int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }

        return dp[m-1][n-1];

    }

}
