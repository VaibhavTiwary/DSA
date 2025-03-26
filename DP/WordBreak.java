// Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a 
// space-separated sequence of one or more dictionary words.

// Note that the same word in the dictionary may be reused multiple times in the segmentation.

 

// Example 1:

// Input: s = "leetcode", wordDict = ["leet","code"]
// Output: true
// Explanation: Return true because "leetcode" can be segmented as "leet code".

// TC- O(n^2)

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        Boolean[] dp = new Boolean[s.length()];  // Memo array
        return solve(s, words, 0, dp);
    }

    boolean solve(String s, Set<String> words, int index, Boolean[] dp) {
        if (index == s.length()) {
            return true;
        }

        if (dp[index] != null) {
            return dp[index];
        }

        StringBuilder builder = new StringBuilder();

        for (int i = index; i < s.length(); i++) {
            builder.append(s.charAt(i));

            if (words.contains(builder.toString())) {
                if (solve(s, words, i + 1, dp)) {
                    dp[index] = true;
                    return true;
                }
            }
        }

        dp[index] = false;
        return false;
    }
}