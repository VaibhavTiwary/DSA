// You are given a 0-indexed integer array nums and an integer p. Find p pairs of indices of nums 
// such that the maximum difference amongst all the pairs is minimized. Also, ensure no index 
// appears more than once amongst the p pairs.

// Note that for a pair of elements at the index i and j, the difference of this pair is
//  |nums[i] - nums[j]|, where |x| represents the absolute value of x.

// Return the minimum maximum difference among all p pairs. We define the maximum of an empty set
//  to be zero.

 

// Example 1:

// Input: nums = [10,1,2,7,1,3], p = 2
// Output: 1
// Explanation: The first pair is formed from the indices 1 and 4, and the second pair is formed 
// from the indices 2 and 5. 
// The maximum difference is max(|nums[1] - nums[4]|, |nums[2] - nums[5]|) = max(0, 1) = 1. 
// Therefore, we return 1.
// Example 2:

// Input: nums = [4,2,1,2], p = 1
// Output: 0
// Explanation: Let the indices 1 and 3 form a pair. The difference of that pair is |2 - 2| = 0,
//  which is the minimum we can attain.

//We need to find p pairs, find max diff among them 
// and then select the minimum among all max differences selected from all p pairs


// .Sort the array: to minimize differences between neighbors.
// .Binary search the answer (mid).
// .For each mid, count how many adjacent pairs can be formed with difference ≤ mid.
// .If you can form at least p pairs: maybe there’s a smaller max difference possible.
// .Otherwise, you must increase the allowed difference.


class Solution {
    public int minimizeMax(int[] nums, int p) {
        if (p == 0) return 0;
        Arrays.sort(nums);
        int n = nums.length, left = 0, right = nums[n-1] - nums[0];
        while (left < right) {
            int mid = left + (right - left) / 2, pairs = 0;
            for (int i = 1; i < n; i++) {
                if (nums[i] - nums[i-1] <= mid) {
                    pairs++;
                    i++;
                }
            }
            if (pairs >= p) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}