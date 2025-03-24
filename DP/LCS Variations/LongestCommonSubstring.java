// You are given two strings s1 and s2. Your task is to find the length of the longest common substring
//  among the given strings.

// Examples:

// Input: s1 = "ABCDGH", s2 = "ACDGHR"
// Output: 4
// Explanation: The longest common substring is "CDGH" with a length of 4.

//If characters matches increment count but if not then resent count to 0



class Solution {
    public int longestCommonSubstr(String s1, String s2) {
        int length1 = s1.length();
        int length2 = s2.length();

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
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = 0;
                }
            }
        }
        
        int max = dp[1][1];
        for(int i = 1; i <= length1; i++){          //Getting max as it can be anywhere in the table
            for(int j = 1; j <= length2; j++){
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}