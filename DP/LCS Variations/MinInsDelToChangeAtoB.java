// Given two strings s1 and s2. The task is to remove or insert the minimum number of characters 
// from/in s1 to transform it into s2. It could be possible that the same character needs to be removed 
// from one point of s1 and inserted into another point.

// Examples :

// Input: s1 = "heap", s2 = "pea"
// Output: 3
// Explanation: 'p' and 'h' deleted from heap. Then, 'p' is inserted at the beginning.


class Solution {
    public int minOperations(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n+1][m+1];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= m; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
            }
        }
        int lcs = LCS(s1, s2, n, m, dp);
        return ((n - lcs) + (m - lcs));
    }
    int LCS(String s1, String s2, int n, int m, int[][] dp){
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[n][m];
    }
}