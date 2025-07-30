// Given an array of positive integers arr[] and a value sum, determine if there is a subset of arr[] with 
// sum equal to given sum. 

// Examples:

// Input: arr[] = [3, 34, 4, 12, 5, 2], sum = 9
// Output: true 
// Explanation: Here there exists a subset with target sum = 9, 4+3+2 = 9.


// TC- O(n*sum)
class Solution {
    public static boolean isSubsetSum(int[] arr, int sum) {
        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];

        // Base Case: sum = 0 → true for all rows
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Base Case: 0 elements → false for all sums > 0
        for (int j = 1; j <= sum; j++) {
            dp[0][j] = false;
        }

        // Tabulation
        for (int i = 1; i <= n; i++) {
            for (int target = 1; target <= sum; target++) {
                boolean notPick = dp[i - 1][target];
                boolean pick = false;
                if (arr[i - 1] <= target) {
                    pick = dp[i - 1][target - arr[i - 1]];
                }

                dp[i][target] = pick || notPick;
            }
        }

        return dp[n][sum];
    }
}


class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;

        // dp[i][j] means: is it possible to form sum `j` using elements from index `i` onward
        Boolean[][] dp = new Boolean[n][sum + 1];
        return solve(arr, sum, 0, dp);
    }

    static boolean solve(int[] arr, int sum, int start, Boolean[][] dp) {
        if (sum == 0) return true;
        if (start == arr.length) return false;

        if (dp[start][sum] != null) return dp[start][sum];

        boolean notPick = solve(arr, sum, start + 1, dp);

        boolean pick = false;
        if (arr[start] <= sum) {
            pick = solve(arr, sum - arr[start], start + 1, dp);
        }

        return dp[start][sum] = pick || notPick;
    }
}
