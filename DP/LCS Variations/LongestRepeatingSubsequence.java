// Given string str, find the length of the longest repeating subsequence such that it can be found
//  twice in the given string.

// The two identified subsequences A and B can use the same ith character from string s if and only 
// if that ith character has different indices in A and B. For example, A = "xax" and B = "xax" then 
// the index of the first "x" must be different in the original string for A and B.

// Input: s = "axxzxy"
// Output: 2
// Explanation: The given array with indexes looks like
// a x x z x y 
// 0 1 2 3 4 5
// The longest subsequence is "xx". It appears twice as explained below.
// subsequence A
// x x
// 0 1  <-- index of subsequence A
// ------
// 1 2  <-- index of s
// subsequence B
// x x
// 0 1  <-- index of subsequence B
// ------
// 2 4  <-- index of s
// We are able to use character 'x' (at index 2 in s) in both subsequences as it appears on index 1 in 
// subsequence A and index 0 in subsequence B.

class Solution {
    public int LongestRepeatingSubsequence(String s) {
        String text1 = s;
        String text2 = s;
        
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
                if(text1.charAt(i-1) == text2.charAt(j-1) && i != j){
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
