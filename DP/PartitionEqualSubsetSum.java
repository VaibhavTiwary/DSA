// Given an integer array nums, return true if you can partition the array into two subsets such that 
// the sum of the elements in both subsets is equal or false otherwise.

// Example 1:

// Input: nums = [1,5,11,5]
// Output: true
// Explanation: The array can be partitioned as [1, 5, 5] and [11].


//SUBSET SUM METHOD IS ALSO INCLUDED IN THIS
//If sum of elements of array is odd that means there can not be 2 equal partitions so we return false
// otherwise we are calculating subset with sum equal to half of total sum as if we got one subset then 
// automatically second subset would also be available


// TC & SC- O(N * Target)








class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for(int i = 0; i < n; i++){
            sum += nums[i];
        }

        if(sum % 2 != 0) return false;
        else{
            return subsetSum(nums, sum/2, n);
        }

    }

    boolean subsetSum(int[] nums, int target, int n){
        boolean[][] dp = new boolean[n + 1][target + 1];
        for(int i = 0; i <= n; i++){
            dp[i][0] = true;
        }


        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= target; j++){
                if(nums[i-1] <= j){
                    dp[i][j] = dp[i-1][j-nums[i-1]] || dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][target];
    }
}