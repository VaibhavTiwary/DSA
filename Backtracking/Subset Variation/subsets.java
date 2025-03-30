// Given an integer array nums of unique elements, return all possible subsets (the power set).

// The solution set must not contain duplicate subsets. Return the solution in any order.

 

// Example 1:

// Input: nums = [1,2,3]
// Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> newList = new ArrayList<>();
        solve(nums, 0, newList, list);
        return list;
    }

    public void solve(int[] nums, int index, List<Integer>newList, List<List<Integer>> list){
        if(index == nums.length){
            list.add(new ArrayList<>(newList));
            return;
        }
        newList.add(nums[index]);
        solve(nums, index+1, newList, list);
        newList.remove(newList.size()-1);
        solve(nums, index+1, newList, list);
    }
}