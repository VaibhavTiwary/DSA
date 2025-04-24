// You are given an array nums consisting of positive integers.

// We call a subarray of an array complete if the following condition is satisfied:

// The number of distinct elements in the subarray is equal to the number of distinct elements in
//  the whole array.
// Return the number of complete subarrays.

// A subarray is a contiguous non-empty part of an array.

 

// Example 1:

// Input: nums = [1,3,1,2,2]
// Output: 4
// Explanation: The complete subarrays are the following: [1,3,1,2], [1,3,1,2,2], [3,1,2] and [3,1,2,2].

//Once we reached the desired condiiton then all the elements from that index can be a part of 
// the window so we just added n - right

class Solution {
    public int countCompleteSubarrays(int[] nums) {

        HashMap <Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int countDistinct = map.size();

        HashMap <Integer, Integer> count = new HashMap<>();
        int n = nums.length;
        int ans = 0;

        int left = 0;
        for(int right = 0; right < n; right++){
            count.put(nums[right], count.getOrDefault(nums[right], 0) + 1);

            while(count.size() == countDistinct){
                ans += (n- right);
                if(count.get(nums[left]) == 1){
                    count.remove(nums[left]);
                }else{
                    count.put(nums[left], count.get(nums[left]) - 1);
                }
                left++;
            }
        }
        return ans;

    }
}
