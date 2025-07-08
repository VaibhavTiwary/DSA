// Given a triangle array, return the minimum path sum from top to bottom.

// For each step, you may move to an adjacent number of the row below. 
// More formally, if you are on index i on the current row, you may move to either 
// index i or index i + 1 on the next row.


// Example 1:

// Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
// Output: 11
// Explanation: The triangle looks like:
//    2
//   3 4
//  6 5 7
// 4 1 8 3
// The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).


class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();
        int[][] dp = new int[n][n];

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        return dfs(0, 0, triangle, dp);
    }

    int dfs(int row, int col, List<List<Integer>> triangle, int[][] dp){
        if(row == triangle.size() - 1){
            return triangle.get(row).get(col);
        }

        if(dp[row][col] != -1) return dp[row][col];

        int sameInd = dfs(row + 1, col, triangle, dp);
        int nextInd = dfs(row + 1, col + 1, triangle, dp);

        dp[row][col] = triangle.get(row).get(col) + Math.min(sameInd, nextInd);
        return dp[row][col];

    }
}


//Bottom-Up
// We start from the bottom row, and build the minimum path sum from bottom to top.
// Why? Because:

// At the last row, the values are final (no path below).
// Every cell above depends only on two children below: i and i+1.

// dp[j] stores the minimum path sum from triangle[row][j] to the bottom of the triangle.

// At each cell, you're allowed to move to either index j or j+1 in the next row.

// So for any triangle[i][j], you can go to:
// triangle[i+1][j] ⬇️ (down)
// triangle[i+1][j+1] ⬊ (down-right)

// ---dp[j] = triangle[i][j] + Math.min(dp[j], dp[j + 1]);
// dp[j]: the minimum path sum from cell (i+1, j) to bottom
// dp[j+1]: the minimum path sum from cell (i+1, j+1) to bottom



class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];

        // Start with the last row values
        for (int j = 0; j < n; j++) {
            dp[j] = triangle.get(n - 1).get(j);
        }

        // Go from second-last row to top
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }

        return dp[0];
    }
}

