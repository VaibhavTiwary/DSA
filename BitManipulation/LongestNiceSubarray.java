// You are given an array nums consisting of positive integers.

// We call a subarray of nums nice if the bitwise AND of every pair of elements that are in different
// positions in the subarray is equal to 0.

// Return the length of the longest nice subarray.

// A subarray is a contiguous part of an array.

// Note that subarrays of length 1 are always considered nice.


// Input: nums = [1,3,8,48,10]
// Output: 3
// Explanation: The longest nice subarray is [3,8,48]. This subarray satisfies the conditions:
// - 3 AND 8 = 0.
// - 3 AND 48 = 0.
// - 8 AND 48 = 0.
// It can be proven that no longer nice subarray can be obtained, so we return 3.

// We are using bitmasking in this question.
//Detailed explanation of approach and everything is there in notebook.
// TC- O(N) 
class Solution {
    public int longestNiceSubarray(int[] nums) {
        int left = 0;
        int bitmask = 0;
        int maxLen = Integer.MIN_VALUE;

        for(int right = 0; right < nums.length; right++){
            while((nums[right] & bitmask) != 0){
                bitmask = bitmask ^ nums[left];
                left++;
            }
            bitmask = bitmask | nums[right];
            maxLen = Math.max(maxLen, right - left + 1);

        }
        return maxLen;
    }

    
}


 