// Given an array arr[] which represents the dimensions of a sequence of matrices where the ith matrix 
// has the dimensions (arr[i-1] x arr[i]) for i>=1, find the most efficient way to multiply these matrices
//  together. The efficient way is the one that involves the least number of multiplications.

// Examples:

// Input: arr[] = [2, 1, 3, 4]
// Output: 20
// Explanation: There are 3 matrices of dimensions 2 × 1, 1 × 3, and 3 × 4, Let this 3 input matrices be M1, M2, and M3. There are two ways to multiply: ((M1 x M2) x M3) and (M1 x (M2 x M3)), note that the result of (M1 x M2) is a 2 x 3 matrix and result of (M2 x M3) is a 1 x 4 matrix. 
// ((M1 x M2) x M3)  requires (2 x 1 x 3) + (2 x 3 x 4) = 30 
// (M1 x (M2 x M3))  requires (1 x 3 x 4) + (2 x 1 x 4) = 20. 
// The minimum of these two is 20.

// Time Complexity: O(n³)

// Space Complexity: O(n²)

class Solution {
    static int matrixMultiplication(int arr[]) {
        int n = arr.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return solve(arr, 1, n-1, dp);
        
    }
    static int solve(int[] arr, int i, int j, int[][] dp){
        if(i >= j) return 0;
        
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        
        int minCost = Integer.MAX_VALUE;
        
        for(int k = i; k < j; k++){
            int cost = solve(arr, i, k, dp) + solve(arr, k+1, j, dp) + arr[i-1] * arr[k] * arr[j];
            minCost = Math.min(minCost, cost);
        }
        dp[i][j] = minCost;
        return dp[i][j];
    }
}
