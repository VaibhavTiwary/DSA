// You are given an integer array nums of size n.

// Consider a non-empty subarray from nums that has the maximum possible bitwise AND.

// In other words, let k be the maximum value of the bitwise AND of any subarray of nums. Then, only subarrays with a bitwise AND equal to k should be considered.
// Return the length of the longest such subarray.

// The bitwise AND of an array is the bitwise AND of all the numbers in it.

// A subarray is a contiguous sequence of elements within an array.

 

// Example 1:

// Input: nums = [1,2,3,3,2,2]
// Output: 2
// Explanation:
// The maximum possible bitwise AND of a subarray is 3.
// The longest subarray with that value is [3,3], so we return 2.
// Example 2:

// Input: nums = [1,2,3,4]
// Output: 1
// Explanation:
// The maximum possible bitwise AND of a subarray is 4.
// The longest subarray with that value is [4], so we return 1.


class Solution {
    public int longestSubarray(int[] nums) {
        //AND operation of 2 numbers will always be lesser than max of two nos.
        //we need maximum AND so we need to get max from nums.
        //if we get max from nums then AND of them will be same ... if max is 5 we will look for longest consecutive streak of 5 as 5 AND 5 = 5
        //and AND of same numbers are number itself.
        //to get maximum AND and longest subarray, find max number and check the longest  sequence of that number in the array

        int max = -1;
        for(int num : nums){
            max = Math.max(max, num);
        }

        int count = 1;
        int maxCount = 1;
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i] == max){
                if(nums[i] == nums[i+1]){
                    count++;
                    maxCount = Math.max(count, maxCount);
                }
                else count = 1;
            }
        }
        return maxCount;

    }
}