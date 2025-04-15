// You are given an array of words where each word consists of lowercase English letters.

// wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in wordA without changing the order of the other characters to make it equal to wordB.

// For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".
// A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is a
//  predecessor of word2, word2 is a predecessor of word3, and so on. A single word is trivially a 
//  word chain with k == 1.

// Return the length of the longest possible word chain with words chosen from the given list of words.

 

// Example 1:

// Input: words = ["a","b","ba","bca","bda","bdca"]
// Output: 4
// Explanation: One of the longest word chains is ["a","ba","bda","bdca"].
// Example 2:

// Input: words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
// Output: 5
// Explanation: All the words can be put in a word chain ["xb", "xbc", "cxbc", "pcxbc", "pcxbcf"].


// Overall Time Complexity = O(n log n + n^2).

// Time Complexity: O(n^2) (after considering recursion and memoization).

// Space Complexity: O(n^2) (due to memoization and recursion stack).

class Solution {

    int[][] dp;
    
    public int longestStrChain(String[] words) {
        
        if(words.length == 1) return 1;

        dp = new int[1000][1001]; 
        for (int[] row : dp)
            Arrays.fill(row, -1);

        Arrays.sort(words, (a, b) -> a.length() - b.length());

        int curIdx = 0;
        int prevIdx = -1;
        return solve(curIdx, prevIdx, words);
        
    }

    int solve(int curIdx, int prevIdx, String[] words){
        if(curIdx == words.length) return 0;

        if (dp[curIdx][prevIdx + 1] != -1)
            return dp[curIdx][prevIdx + 1];

        int notPick = solve(curIdx + 1, prevIdx, words);

        int pick = 0;
        if(prevIdx == -1 || isValid(curIdx, prevIdx, words)){
            pick = 1 + solve(curIdx + 1, curIdx, words);
            
        }
        dp[curIdx][prevIdx + 1] = Math.max(notPick, pick);
        return dp[curIdx][prevIdx + 1];

    }

    boolean isValid(int cur, int prev, String[] words){
        String curWord = words[cur];
        String prevWord = words[prev];

        if (curWord.length() != prevWord.length() + 1) return false;

        int curit = 0;
        int previt = 0;
        int cnt = 0;
        while(curit < curWord.length() && previt < prevWord.length()){
            if(curWord.charAt(curit) == prevWord.charAt(previt)){
                curit++;
                previt++;
            }
            else{
                cnt++;
                curit++;  
                if (cnt > 1) return false;
            }
        }
        return true;
    }
}