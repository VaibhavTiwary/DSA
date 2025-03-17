// Given an array arr of non-negative integers and an integer target, the task is to count all subsets of 
// the array whose sum is equal to the given target.

// Input: arr[] = [5, 2, 3, 10, 6, 8], target = 10
// Output: 3
// Explanation: The subsets {5, 2, 3}, {2, 8}, and {10} sum up to the target 10.

//But there can be case where array will contain 0 so we have initialized table with 1 in first column 
// for sum = 0 there will always be 1 subset that is {}.
// The DP relation: dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i-1]];
// for arr[i-1] = 0 relation will become-  dp[i][j] = dp[i-1][j] + dp[i-1][j];
// as in first relation put arr[i-1] = 0

// This effectively doubles the count of subsets forming sum j


class Solution {
    public int perfectSum(int[] nums, int target) {
        int n = nums.length;
        
        int[][] dp = new int[n+1][target+1];

        // Base Case: If sum is 0, there's always 1 subset (empty set)
        for (int i = 0; i <= n; i++){
            dp[i][0] = 1;
        }
        for (int j = 1; j <= target; j++){
            dp[0][j] = 0;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                if (nums[i-1] <= j) {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
                } 
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][target];
    }
}