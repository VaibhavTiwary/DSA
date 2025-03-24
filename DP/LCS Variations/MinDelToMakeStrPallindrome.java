// Given a string 'str' of size ‘n’. The task is to remove or delete the minimum number of characters 
// from the string so that the resultant string is a palindrome. Find the minimum number of characters 
// we need to remove.
// Note: The order of characters should be maintained.

// Example 1:

// Input: n = 7, str = "aebcbda"
// Output: 2
// Explanation: We'll remove 'e' and
// 'd' and the string become "abcba".

class Solution 
{ 
    int minDeletions(String str, int n)
    {
        String temp = reverse(str);

        int[][] dp = new int[n+1][n+1];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= n; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
            }
        }
        int lcs = LCS(str, temp, n, dp);
        return n - lcs;
    }
    
    int LCS(String str, String temp, int n, int[][] dp){
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(str.charAt(i-1) == temp.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[n][n];
    }

    String reverse(String str){
        String reversed = new StringBuilder(str).reverse().toString();
        return reversed;
    }
}