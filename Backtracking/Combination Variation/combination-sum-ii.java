// Given a collection of candidate numbers (candidates) and a target number (target), 
// find all unique combinations in candidates where the candidate numbers sum to target.

// Each number in candidates may only be used once in the combination.

// Note: The solution set must not contain duplicate combinations.

 

// Example 1:

// Input: candidates = [10,1,2,7,6,1,5], target = 8
// Output: 
// [
// [1,1,6],
// [1,2,5],
// [1,7],
// [2,6]
// ]


class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        solve(0, candidates, target, temp, ans);
        return ans;
    }

      private void solve(int index, int[] candidates, int target, List<Integer> temp, List<List<Integer>> ans) {

        if(target == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i = index; i < candidates.length; i++) {
            if(i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }

            if(candidates[i] > target) break; 
            temp.add(candidates[i]);
            solve(i + 1, candidates, target - candidates[i], temp, ans);
            temp.remove(temp.size() - 1); // Backtrack
        }
    }

}

