// Given an integer array nums, return the length of the longest strictly increasing subsequence.

 

// Example 1:

// Input: nums = [10,9,2,5,3,7,101,18]
// Output: 4
// Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.


//Backtracking approach
class Solution {

    int max_size = Integer.MIN_VALUE;

    public int lengthOfLIS(int[] nums) {
        ArrayList <Integer> list =  new ArrayList<>();
        
        backtrack(nums, 0, list);
        return max_size;
    }
    void backtrack(int[] nums, int index, ArrayList <Integer> list){
        if(index == nums.length){
            return;
        }

        for(int i = index; i < nums.length; i++){
            if(list.size() == 0 || nums[i] > list.get(list.size() - 1)){
                list.add(nums[i]);
                max_size = Math.max(max_size, list.size());
                backtrack(nums, i + 1, list);
                list.remove(list.size() - 1);
            }
            
        }

    }
}

//Memoization
class Solution {

    int[][] dp;
    int[] nums;

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        this.nums = nums;
        dp = new int[n][n + 1]; // prevIndex can be -1, so offset by +1
        for (int[] row : dp)
            Arrays.fill(row, -1);

        return helper(0, -1);
    }

    private int helper(int index, int prevIndex) {
        if (index == nums.length)
            return 0;

        if (dp[index][prevIndex + 1] != -1)
            return dp[index][prevIndex + 1];

        // Option 1: skip current element
        int notTake = helper(index + 1, prevIndex);

        // Option 2: take current element if valid
        int take = 0;
        if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
            take = 1 + helper(index + 1, index);
        }

        return dp[index][prevIndex + 1] = Math.max(take, notTake);
    }
}

//Binary Search
//O(N Log N)

class Solution {
    public int lengthOfLIS(int[] nums){
    
        int size = nums.length;

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(nums[0]);

        // int len = 1;
        for (int i = 1; i < size; i++) {
            if (nums[i] > ans.get(ans.size() - 1)) {
                ans.add(nums[i]);
                // len++;
            } else {
                int indx = binarySearch(ans, nums[i]);
                ans.set(indx, nums[i]);
            }
        }
        return ans.size();
    }

    static int binarySearch(ArrayList<Integer> ans, int key) {
        int low = 0;
        int high = ans.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (ans.get(mid) == key) return mid;
            else if (ans.get(mid) < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high + 1;
    }


    
}


    
    