// Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

// The solution set must not contain duplicate subsets. Return the solution in any order.

 

// Example 1:

// Input: nums = [1,2,2]
// Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]


class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);
        solve(nums, ans, subset, 0);
        return ans;
    }

    void solve(int[] nums, List<List<Integer>> ans, List<Integer> subset, int index){
        ans.add(new ArrayList<>(subset));
        
        for(int i = index; i < nums.length; i++){
            if(i > index && nums[i] == nums[i-1]) continue;

            subset.add(nums[i]);
            solve(nums, ans, subset, i+1);
            subset.remove(subset.size()-1);
        }

    }
}