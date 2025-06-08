// Given an integer n, return all the numbers in the range [1, n] sorted in lexicographical order.

// You must write an algorithm that runs in O(n) time and uses O(1) extra space. 

// Example 1:
// Input: n = 13
// Output: [1,10,11,12,13,2,3,4,5,6,7,8,9]

//Brute Force but is very slow
class Solution {
    public List<Integer> lexicalOrder(int n) {

        List<String> temp = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            temp.add(String.valueOf(i));
        }
        Collections.sort(temp);

        List<Integer> ans = new ArrayList<>();
        for (String s : temp) {
            ans.add(Integer.parseInt(s));
        }

        return ans;

    }
}

// Treat the lexicographical order as a tree traversal:

// Start with 1 to 9.

// For each number, add *10 + i (where i is 0–9), as long as it's ≤ n.

// - Start DFS from numbers 1 to 9 (the valid leading digits).
// - For each number curr, append it to result.
// - Try to go deeper by appending 0–9 (curr * 10 + i) and continue DFS.
// - Stop when the number exceeds n.



class Solution {
    public List<Integer> lexicalOrder(int n) {

        List<Integer> ans = new ArrayList<>();

        for(int i = 1; i <= 9; i++){
            dfs(i, n, ans);
        }
        return ans;
    }

    void dfs(int num, int n, List<Integer> ans){
        if(num > n) return;
        ans.add(num);

        for(int i = 0; i <= 9; i++){
            int next = (num * 10) + i;
            if(next > n) break;
            dfs(next, n, ans);
        }
    }
}