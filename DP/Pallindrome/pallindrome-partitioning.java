// Given a string s, partition s such that every substring of the partition is a palindrome. 
// Return all possible palindrome partitioning of s.

 

// Example 1:

// Input: s = "aab"
// Output: [["a","a","b"],["aa","b"]]


//Backtracking Approach
class Solution {
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> partition(String s) {
        ArrayList <String> temp = new ArrayList<>();
        solve(s, 0, temp);
        return ans;
    }

    boolean is_pallindrome(String str){
        int start = 0;
        int end = str.length()-1;
        while(end >= start){
            if(str.charAt(start) != str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }


    void solve(String s, int index, ArrayList <String> temp){
        if(index == s.length()){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i = index; i < s.length(); i++){
            String substring = s.substring(index, i + 1);

            if(is_pallindrome(substring)){
                temp.add(substring);
                solve(s, i + 1, temp);
                temp.remove(temp.size() - 1);
            }

        }
    }
}

//DP
class Solution {
    public ArrayList<ArrayList<String>> palinParts(String s) {
        
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        ArrayList<String> partitions = new ArrayList<>();
        
        int n = s.length();
        
        boolean[][] dp = new boolean[n][n];

        // Precomputing all palindromic substrings
        for(int i = n - 1; i >= 0; i--){
            for(int j = i; j < n; j++){
                if(s.charAt(i) == s.charAt(j)){
                    if(j - i <= 2) dp[i][j] = true; //if substring is of length 1 or 2 and both chars at i and j are equal then true
                    else dp[i][j] = dp[i+1][j-1];
                    //for greater lengths ex- abcba (i - 0, j - 4)
                    //if i and j chars are equal then check for dp[i+1][j-1] and if that true then true
                }
            }
        }

        solve(s, ans, partitions, 0, dp);
        return ans;
    }
    
    public void solve(String s, ArrayList<ArrayList<String>> ans, ArrayList<String> partitions, int start, boolean[][] dp){
        if(start == s.length()){
            ans.add(new ArrayList<>(partitions));
            return;
        }
        
        for(int i = start; i < s.length(); i++){
            if(dp[start][i]){
                partitions.add(s.substring(start, i+1));
                solve(s, ans, partitions, i+1, dp);
                partitions.remove(partitions.size() - 1);
            }
        }
    }
}
