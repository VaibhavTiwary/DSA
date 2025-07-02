// There is a robot on an m x n grid. The robot is initially located at the top-left corner
//  (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
//   The robot can only move either down or right at any point in time.

// Given the two integers m and n, return the number of possible unique paths that the robot can 
// take to reach the bottom-right corner.

// The test cases are generated so that the answer will be less than or equal to 2 * 109.

 

// Example 1:


// Input: m = 3, n = 7
// Output: 28
// Example 2:

// Input: m = 3, n = 2
// Output: 3
// Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
// 1. Right -> Down -> Down
// 2. Down -> Down -> Right
// 3. Down -> Right -> Down


//Recursive solution 
// TC- O(2^(m+n))

// ...................🧠 What's happening?.............................
// At each cell (i, j), the function:
// Recursively tries to go right → (i, j + 1)
// And down → (i + 1, j)
// So from every cell, it splits into 2 recursive calls.

class Solution {
    public int uniquePaths(int m, int n) {
        return solve(0, 0, m, n);
    }

    int solve(int i, int j, int m, int n){
        if(i == m-1 && j == n-1) return 1;

        if(i >= m || j >= n) return 0;

        int right = solve(i, j+1, m, n);
        int down = solve(i+1, j, m, n);

        return right + down;
    }
}


//Memoization
// TC- O(M*N)

// ..................✅ How it becomes O(m × n)?............................
// The grid has m rows and n columns → total unique positions = m × n
// Each unique (i, j) is computed only once
// After that, it's returned from cache (dp[i][j])
// So total number of computations = m × n


class Solution {
    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m+1][n+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        return solve(0, 0, m, n, dp);
    }

    int solve(int i, int j, int m, int n, int[][] dp){

        if(i == m-1 && j == n-1) return 1;
        if(i >= m || j >= n) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int right = solve(i, j+1, m, n, dp);
        int down = solve(i+1, j, m, n, dp);

        dp[i][j] = right + down;
        return dp[i][j];
    }
}

// "I started with recursion + memoization for clarity, but to avoid call stack overhead,
//  I’ll switch to bottom-up tabulation for better space control and performance."


// dp[i][j] means: number of ways to reach cell (i, j)

// Only two ways to get there:

// From top: dp[i-1][j]
// From left: dp[i][j-1]

// Base cases: First row and column = 1 way (only one direction possible)

// ...........DP TABLE.................
// [1, 1, 1, 1, 1, 1, 1]
// [1, 2, 3, 4, 5, 6, 7]
// [1, 3, 6,10,15,21,28]

public class UniquePaths {

    public int uniquePaths(int m, int n) {
        // Create a DP table of size m x n
        int[][] dp = new int[m][n];

        // Fill the first row with 1s (only right moves possible)
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        // Fill the first column with 1s (only down moves possible)
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        // Fill the rest of the table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // Current cell = ways from top + ways from left
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        // The bottom-right cell contains the final answer
        return dp[m - 1][n - 1];
    }
}


