// Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k 
// odd numbers on it.

// Return the number of nice sub-arrays.

 

// Example 1:

// Input: nums = [1,1,2,1,1], k = 3
// Output: 2
// Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].



class Solution {
    public int numberOfSubarrays(int[] nums, int k) {

       int[] temp = new int[nums.length];
       int j = 0;

       for(int i = 0; i < nums.length; i++){
            if(nums[i] % 2 == 0) temp[j++] = 0;
            else temp[j++] = 1;
       }

       HashMap <Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int ans = 0;

        for(int num : temp){
            sum += num;
            if(map.containsKey(sum - k)){
                ans += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return ans;
    }
}