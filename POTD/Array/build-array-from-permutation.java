// L-1920

// Given a zero-based permutation nums (0-indexed), build an array ans of the same length where 
// ans[i] = nums[nums[i]] for each 0 <= i < nums.length and return it.

// A zero-based permutation nums is an array of distinct integers from 0 to nums.length - 1 (inclusive).

 

// Example 1:

// Input: nums = [0,2,1,5,3,4]
// Output: [0,1,2,4,5,3]

class Solution {
    public int[] buildArray(int[] nums) {
    
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > i){
                nums[i] = (nums[i] * nums.length) + nums[nums[i]];
            }
            else if(nums[i] < i){
                nums[i] = (nums[i] * nums.length) + (nums[nums[i]] / nums.length);
            }
        }
        
        for(int j = 0; j < nums.length; j++){
            nums[j] = nums[j] % nums.length;
        }
        return nums;
    }
}