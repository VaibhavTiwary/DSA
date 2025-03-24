// You are given an integer array nums and an integer target.

// You want to build an expression out of nums by adding one of the symbols '+' and '-' before each 
// integer in nums and then concatenate all the integers.

// For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to 
// build the expression "+2-1".
// Return the number of different expressions that you can build, which evaluates to target.

// Input: nums = [1,1,1,1,1], target = 3
// Output: 5
// Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
// -1 + 1 + 1 + 1 + 1 = 3
// +1 - 1 + 1 + 1 + 1 = 3
// +1 + 1 - 1 + 1 + 1 = 3
// +1 + 1 + 1 - 1 + 1 = 3
// +1 + 1 + 1 + 1 - 1 = 3

//BACKTRACKING APPROACH

// class Solution {
//     public int findTargetSumWays(int[] nums, int target) {
//         int output = 0;
//         return solve(nums, 0, output, target);

//     }

//     int solve(int[] nums, int start, int output, int target){
//         if(start == nums.length){
//             if(output ==target){
//                 return 1;
//             }else{
//                 return 0;
//             }
//         }
//         int output1 = output + nums[start];
//         int output2 = output - nums[start];

//         int res1 = solve(nums, start+1, output1, target);
//         int res2 = solve(nums, start+1, output2, target);
//         return res1 + res2;
//     }
// }


//DP
// It also comes down to subset sum variation as we can divide the subset as partition of 2 subsets 
// with sum given in question
// for 1,1,2,3 and sum = 1
// we have +1 -1 -2 +3
// 2 subsets can be (+1 + 3) - (1 + 2)
// it becomes partitions with given difference.
// will be solved using sum1 = (sum + d)/2; and here d is the sum given in the problem.

// TC and SC = O(N * target)

class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i];
        }
        if (target > sum || (sum + target) % 2 != 0 || (sum + target) < 0) {
            return 0;
        }

        
        int newTarget = (sum + target)/2;
        
        int[][] dp = new int[n+1][newTarget+1];
        
        for (int i = 0; i <= n; i++){
            dp[i][0] = 1;
        }
        for (int j = 1; j <= newTarget; j++){
            dp[0][j] = 0;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= newTarget; j++) {
                if (nums[i-1] <= j) {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
                } 
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[n][newTarget];
    }

    
}



    
    