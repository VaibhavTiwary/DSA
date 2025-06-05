class Solution {
    int lcsOf3(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        int o = s3.length();
        
        int[][][] dp = new int[m + 1][n + 1][o + 1];
        for (int[][] mat : dp) {
            for (int[] row : mat) {
                Arrays.fill(row, -1);
            }
        }
        return lcs(s1, s2, s3, m, n, o, dp);
    }
    
    int lcs(String s1, String s2, String s3, int i, int j, int k, int[][][] dp) {
        if (i == 0 || j == 0 || k == 0) return 0;
        
        if (dp[i][j][k] != -1) return dp[i][j][k];
        
        if (s1.charAt(i - 1) == s2.charAt(j - 1) && s1.charAt(i - 1) == s3.charAt(k - 1)) {
            return dp[i][j][k] = 1 + lcs(s1, s2, s3, i - 1, j - 1, k - 1, dp);
        } else {
            return dp[i][j][k] = Math.max(
                lcs(s1, s2, s3, i - 1, j, k, dp),
                Math.max(
                    lcs(s1, s2, s3, i, j - 1, k, dp),
                    lcs(s1, s2, s3, i, j, k - 1, dp)
                )
            );
        }
    }
}