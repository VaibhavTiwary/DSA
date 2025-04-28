// The score of an array is defined as the product of its sum and its length.

// For example, the score of [1, 2, 3, 4, 5] is (1 + 2 + 3 + 4 + 5) * 5 = 75.
// Given a positive integer array nums and an integer k, return the number of non-empty subarrays of 
// nums whose score is strictly less than k.

// A subarray is a contiguous sequence of elements within an array.

 

// Example 1:

// Input: nums = [2,1,4,3,5], k = 10
// Output: 6
// Explanation:
// The 6 subarrays having scores less than 10 are:
// - [2] with score 2 * 1 = 2.
// - [1] with score 1 * 1 = 1.
// - [4] with score 4 * 1 = 4.
// - [3] with score 3 * 1 = 3. 
// - [5] with score 5 * 1 = 5.
// - [2,1] with score (2 + 1) * 2 = 6.

class Solution {
    public long countSubarrays(int[] nums, long k) {
        
        long subarrays = 0;
        int i = 0;
        long sum = 0;
        
        for(int j = 0; j < nums.length; j++){
            sum += nums[j];

            while(sum * (j-i+1) >= k){
                sum -= nums[i];
                i++;
            }
            
            subarrays += (j - i + 1);

        }
        return subarrays;

    }
}