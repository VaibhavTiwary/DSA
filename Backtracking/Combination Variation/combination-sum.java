// Given an array of distinct integers candidates and a target integer target, return a list of all 
// unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

// The same number may be chosen from candidates an unlimited number of times. Two combinations are unique
//  if the frequency of at least one of the chosen numbers is different.

// The test cases are generated such that the number of unique combinations that sum up to target is 
// less than 150 combinations for the given input.

 

// Example 1:

// Input: candidates = [2,3,6,7], target = 7
// Output: [[2,2,3],[7]]
// Explanation:
// 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
// 7 is a candidate, and 7 = 7.
// These are the only two combinations.


class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solve(0, candidates, target, temp, ans);
        return ans;
    }

      private void solve(int index, int[] candidates, int target, List<Integer> temp, List<List<Integer>> ans) {
        if(index == candidates.length){
            if(target == 0){
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        if(target >= candidates[index]){
            temp.add(candidates[index]);
            solve(index, candidates, target - candidates[index], temp, ans);
            temp.remove(temp.size()-1);
        }
        solve(index+1, candidates, target, temp, ans);
    }
}


//With Loop
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solve(0, candidates, target, temp, ans);
        return ans;
    }

    private void solve(int index, int[] candidates, int target, List<Integer> temp, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                temp.add(candidates[i]);
                solve(i, candidates, target - candidates[i], temp, ans); 
                temp.remove(temp.size() - 1); 
            }
        }
    }
}
