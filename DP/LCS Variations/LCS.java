// Given two strings text1 and text2, return the length of their longest common subsequence. If there is
//  no common subsequence, return 0.

// A subsequence of a string is a new string generated from the original string with some characters 
// (can be none) deleted without changing the relative order of the remaining characters.

// For example, "ace" is a subsequence of "abcde".
// A common subsequence of two strings is a subsequence that is common to both strings.

// Example 1:

// Input: text1 = "abcde", text2 = "ace" 
// Output: 3  
// Explanation: The longest common subsequence is "ace" and its length is 3.

//RECURSIVE APPROACH
// TC- O(2^(m + n))
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int length1 = text1.length();
        int length2 = text2.length();

        return solve(length1, length2, text1, text2);
    }

    int solve(int length1, int length2, String text1, String text2){
        if(length1 == 0 || length2 == 0){
            return 0;
        }

        if(text1.charAt(length1 - 1) == text2.charAt(length2 - 1)){
            return 1 + solve(length1 - 1, length2 - 1, text1, text2);
        }
        else {
            return Math.max(solve(length1 - 1, length2, text1, text2) , 
                            solve(length1, length2 - 1, text1, text2));
        }
    }
}


//MEMOIZATION
// TC - O(M * N)
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int length1 = text1.length();
        int length2 = text2.length();

        int[][] dp = new int[length1 + 1][length2 + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        return solve(length1, length2, text1, text2, dp);
    }

    int solve(int length1, int length2, String text1, String text2, int[][] dp){
        if(length1 == 0 || length2 == 0){
            return 0;
        }

        if(dp[length1][length2] != -1){
            return dp[length1][length2];
        }

        if(text1.charAt(length1 - 1) == text2.charAt(length2 - 1)){
            dp[length1][length2] =  1 + solve(length1 - 1, length2 - 1, text1, text2, dp);
        }
        else {
            dp[length1][length2] =  Math.max(solve(length1 - 1, length2, text1, text2, dp) , 
                            solve(length1, length2 - 1, text1, text2, dp));
        }
        return dp[length1][length2];
    }
}


//TABULATION BOTTOM UP
// TC- O(M*N)
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int length1 = text1.length();
        int length2 = text2.length();

        int[][] dp = new int[length1 + 1][length2 + 1];
        
        for(int i = 0; i <= length1; i++){
            for(int j = 0; j <= length2; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
            }
        }

        for(int i = 1; i <= length1; i++){
            for(int j = 1; j <= length2; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[length1][length2];



        
    }

    
}




//PRINT LCS
class Solution {
    public String longestCommonSubsequence(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        // Build the LCS dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Now backtrack to build the LCS string
        int i = n, j = m;
        StringBuilder lcs = new StringBuilder();

        while (i > 0 && j > 0) {
            // Characters match → part of LCS
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;  // Move up
            } else {
                j--;  // Move left
            }
        }

        return lcs.reverse().toString(); // reverse because we built it backward
    }
}

