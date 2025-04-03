// You are given a 0-indexed integer array nums.

// Return the maximum value over all triplets of indices (i, j, k) such that i < j < k. If all such 
// triplets have a negative value, return 0.

// The value of a triplet of indices (i, j, k) is equal to (nums[i] - nums[j]) * nums[k].

 

// Example 1:

// Input: nums = [12,6,1,2,7]
// Output: 77
// Explanation: The value of the triplet (0, 2, 4) is (nums[0] - nums[2]) * nums[4] = 77.
// It can be shown that there are no ordered triplets of indices with a value greater than 77. 

//Using Extra Space
class Solution {
    public long maximumTripletValue(int[] nums) {

        int n = nums.length;

        int[] curMax = new int[n];
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            max = Math.max(max, nums[i]);
            curMax[i] = max;
        }

        // System.out.println(max);

        int[] maxDiff = new int[n];
        int diff = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            diff = Math.max(diff, curMax[i]-nums[i]);
            maxDiff[i] = diff;
        }
        for(int i = 0; i < maxDiff.length; i++){
            System.out.println(maxDiff[i]);
        }

        long res = Long.MIN_VALUE;
        for(int i = 1; i < n-1; i++){
            long curProd = (long) maxDiff[i] * nums[i + 1];
            res = Math.max(res, curProd);

        }


        return res;
    }
}

//OPtimized
class Solution {
    public long maximumTripletValue(int[] nums) {

        long result = 0;
        long maxi = 0;
        long maxDiff = 0;

        for(int i = 0; i < nums.length; i++){
            result = Math.max(result, maxDiff * nums[i]); //getting result
            maxDiff = Math.max(maxDiff, maxi - nums[i]);  //For max diff subtracting nums[i] with cur max i.e maxii
            maxi = Math.max(maxi, (long) nums[i]);  //calculating current MAX
        }
        return result;
    }
}