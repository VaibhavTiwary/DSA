// You are a professional robber planning to rob houses along a street. Each house has a certain amount
//  of money stashed. All houses at this place are arranged in a circle. That means the first house is 
//  the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, 
//  and it will automatically contact the police if two adjacent houses were broken into on the same night.

// Given an integer array nums representing the amount of money of each house, return the maximum 
// amount of money you can rob tonight without alerting the police.


// Input: nums = [2,3,2]
// Output: 3
// Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), 
// because they are adjacent houses.


// Since House[1] and House[n] are adjacent, they cannot be robbed together. Therefore, the problem 
// becomes to rob either House[1]-House[n-1] or House[2]-House[n], depending on which choice offers 
// more money. Now the problem has degenerated to the House Robber, which is already been solved.

// Create 2 separate methods for both cases on with start = 0 and second with start = 1



class Solution {
    public int rob(int[] nums) {

        int n = nums.length;
        
        if(n == 1) return nums[0];

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        int[] dp1 = new int[n];
        Arrays.fill(dp1, -1);

        int res1 = solve1(nums, 0, dp);
        int res2 = solve2(nums, 1, dp1);
        return Math.max(res1, res2);
    }

    int solve1(int[] nums, int start, int[] dp) {
        if (start >= nums.length-1) return 0;  // Base case as we can not pick last house because we are starting from 0th index
         
        if(dp[start] != -1) return dp[start];
        int include = nums[start] + solve1(nums, start + 2, dp);
        int exclude = solve1(nums, start + 1, dp);
        dp[start] = Math.max(include, exclude);
        
        return dp[start];
    }

    int solve2(int[] nums, int start, int[] dp1) {
        if (start >= nums.length) return 0;  // Base case
         
        if(dp1[start] != -1) return dp1[start];
        int include = nums[start] + solve2(nums, start + 2, dp1);
        int exclude = solve2(nums, start + 1, dp1);
        dp1[start] = Math.max(include, exclude);
        
        return dp1[start];
    }
    
}
