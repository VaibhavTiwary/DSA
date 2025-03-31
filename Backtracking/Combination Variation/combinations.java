// Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

// You may return the answer in any order.

 

// Example 1:

// Input: n = 4, k = 2
// Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
// Explanation: There are 4 choose 2 = 6 total combinations.
// Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.

class Solution {
    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        solve(n, k, ans, res, 1);
        return ans;

    }
    void solve(int n, int k, List<List<Integer>> ans, List<Integer> res, int index){
        if(res.size() == k){
            ans.add(new ArrayList<>(res));
            return;
        }
        for(int i = index; i <= n; i++){
            res.add(i);
            solve(n, k, ans, res, i+1);
            res.remove(res.size()-1);
        }
    }
}