// Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

// Only numbers 1 through 9 are used.
// Each number is used at most once.
// Return a list of all possible valid combinations. The list must not contain the same combination twice, 
// and the combinations may be returned in any order.

 

// Example 1:

// Input: k = 3, n = 7
// Output: [[1,2,4]]
// Explanation:
// 1 + 2 + 4 = 7
// There are no other valid combinations.


class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combinations = new ArrayList<>();

        if(k > n) return ans;

        solve(ans, combinations, k, n, 1);
        return ans;
    }

    void solve(List<List<Integer>> ans, List<Integer> combinations, int k, int target, int start){
        if(k == 0){
            if(target == 0){
                ans.add(new ArrayList<>(combinations));
                return;
            }
        }
        if (k < 0 || target < 0) return;

        for(int i = start; i <= 9; i++){
            combinations.add(i);
            solve(ans, combinations, k - 1, target - i, i + 1);
            combinations.remove(combinations.size() - 1);
        }
        
    }
}