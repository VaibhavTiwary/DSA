// You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]).
//  The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). 
//  The robot can only move either down or right at any point in time.

// An obstacle and space are marked as 1 or 0 respectively in grid. 
// A path that the robot takes cannot include any square that is an obstacle.

// Return the number of possible unique paths that the robot can take to reach the bottom-right corner.

// The testcases are generated so that the answer will be less than or equal to 2 * 109.

 

// Example 1:


// Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
// Output: 2
// Explanation: There is one obstacle in the middle of the 3x3 grid above.
// There are two ways to reach the bottom-right corner:
// 1. Right -> Right -> Down -> Down
// 2. Down -> Down -> Right -> Right


//Recursion
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if(obstacleGrid[m-1][n-1] == 1) return 0;

        return solve(0, 0, m, n, obstacleGrid);
    }

    int solve(int i, int j, int m, int n, int[][] obstacleGrid){

        if(i == m-1 && j == n-1) return 1;
        if(i >= m || j >= n || obstacleGrid[i][j] == 1) return 0;

        int right = solve(i, j+1, m, n, obstacleGrid);
        int down = solve(i+1, j, m, n, obstacleGrid);
        return right + down;
    }
}



//Memoization
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if(obstacleGrid[m-1][n-1] == 1) return 0;

        int[][] dp = new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        return solve(0, 0, m, n, obstacleGrid, dp);
    }

    int solve(int i, int j, int m, int n, int[][] obstacleGrid, int[][] dp){

        if(i == m-1 && j == n-1) return 1;
        if(i >= m || j >= n || obstacleGrid[i][j] == 1) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int right = solve(i, j+1, m, n, obstacleGrid, dp);
        int down = solve(i+1, j, m, n, obstacleGrid, dp);
        dp[i][j] = right + down;
        return dp[i][j];
    }
}


//Bottom-Up

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if(obstacleGrid[m-1][n-1] == 1) return 0;
        if(obstacleGrid[0][0] == 1) return 0;

        int[][] dp = new int[m][n]; //automatically initialized to 0 in java by default
        
        dp[0][0] = 1;
        // we are checking dp[i-1][0] == 1 . If any previous cell in the column had an obstacle, paths after that must be 0.
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 0 && dp[i - 1][0] == 1) {
                dp[i][0] = 1;
            }
        }

        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 0 && dp[0][j - 1] == 1) {
                dp[0][j] = 1;
            }
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
                }
            }
        }
        return dp[m-1][n-1];


    }
}

