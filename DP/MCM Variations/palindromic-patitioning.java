// Given a string s, a partitioning of the string is a palindrome partitioning if every sub-string of 
// the partition is a palindrome. Determine the fewest cuts needed for palindrome partitioning of the 
// given string.

// Examples:

// Input: s = "geek" 
// Output: 2 
// Explanation: We need to make minimum 2 cuts, i.e., "g | ee | k".

// Time Complexity: O(n³)

// Space Complexity: O(n²)

class Solution {
    static int palPartition(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return solve(s, 0, n - 1, dp);
        
    }
    
    static int solve(String s, int i, int j, int[][] dp) {
        if (i >= j || isPalindrome(s, i, j)) return 0;
        
        if (dp[i][j] != -1) return dp[i][j];
        
        int minCuts = Integer.MAX_VALUE;
        
        for (int k = i; k < j; k++) {
            if (isPalindrome(s, i, k)) { 
                int right = solve(s, k + 1, j, dp);
                minCuts = Math.min(minCuts, 1 + right);
                dp[i][j] = minCuts;
            }
            
        }
        
        
        return dp[i][j];
    }
    
    static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}