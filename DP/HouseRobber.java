
//RECURSIVE APPROACH
// TC- O(2^n)
//SC- O(N)
// class Solution {
//     public int rob(int[] nums) {
//         return solve(nums, 0);
//     }

//     int solve(int[] nums, int start) {
//         if (start >= nums.length) return 0;  // Base case
        
//         int include = nums[start] + solve(nums, start + 2);  // Rob this house
//         int exclude = solve(nums, start + 1);  // Skip this house
        
//         return Math.max(include, exclude);
//     }
// }


// TC , SC - O(N)
//MEMOIZATION
class Solution {
    public int rob(int[] nums) {

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(nums, 0, dp);
    }

    int solve(int[] nums, int start, int[] dp) {
        if (start >= nums.length) return 0;  // Base case
         
        if(dp[start] != -1) return dp[start];
        int include = nums[start] + solve(nums, start + 2, dp);
        int exclude = solve(nums, start + 1, dp);
        dp[start] = Math.max(include, exclude);
        
        return dp[start];
    }
}
