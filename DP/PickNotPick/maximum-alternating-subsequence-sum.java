// The alternating sum of a 0-indexed array is defined as the sum of the elements at even indices minus 
// the sum of the elements at odd indices.

// For example, the alternating sum of [4,2,5,3] is (4 + 5) - (2 + 3) = 4.
// Given an array nums, return the maximum alternating sum of any subsequence of nums (after reindexing 
// the elements of the subsequence).

// A subsequence of an array is a new array generated from the original array by deleting some elements
//  (possibly none) without changing the remaining elements' relative order. For example, [2,7,4] is a 
//  subsequence of [4,2,3,7,2,1,4] (the underlined elements), while [2,4,2] is not.

 

// Example 1:

// Input: nums = [4,2,5,3]
// Output: 7
// Explanation: It is optimal to choose the subsequence [4,2,5] with alternating sum (4 + 5) - 2 = 7.
// Example 2:

// Input: nums = [5,6,7,8]
// Output: 8
// Explanation: It is optimal to choose the subsequence [8] with alternating sum 8.
// Example 3:

// Input: nums = [6,2,1,2,4,5]
// Output: 10
// Explanation: It is optimal to choose the subsequence [6,1,5] with alternating sum (6 + 5) - 1 = 10.


//If we will not pick then we will start from next index so we need not to change flag
// ex- 1,2,3,4 if we pick 1 i.e at even index then for index + 1 i.e odd we need to change flag to 0 and
//  val to -val
//  but if we dont pick 1 then our array will be 2,3,4 and curindex will point to 2 and that is 
//  also at index 0 of new array
//so we are not changing our flag if we dont pick




class Solution {
    public long maxAlternatingSum(int[] nums) {
        
        int n = nums.length;

        long[][] dp = new long[n+1][2];
        for(long[] row : dp){
            Arrays.fill(row, -1);
        }

        int flag = 1;
        return solve(0, flag, nums, dp);
    }

    long solve(int index, int flag, int[] nums, long[][] dp){
        if(index == nums.length) return 0;

        if(dp[index][flag] != -1) return dp[index][flag];

        long notPick = solve(index + 1, flag, nums, dp);

        int val = nums[index];
        if(flag == 0) val = -val;
        long pick = val + solve(index + 1, 1-flag, nums, dp);  //if we pick then we will have to change the sign and based on the flag we will do so.
        //if flag ==  0 then we need to subtract thats why we did val = -val;

        return dp[index][flag] = Math.max(pick, notPick);
    }
}