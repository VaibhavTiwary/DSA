// You are given an array of n pairs pairs where pairs[i] = [lefti, righti] and lefti < righti.

// A pair p2 = [c, d] follows a pair p1 = [a, b] if b < c. A chain of pairs can be formed in this fashion.

// Return the length longest chain which can be formed.

// You do not need to use up all the given intervals. You can select pairs in any order.

 

// Example 1:

// Input: pairs = [[1,2],[2,3],[3,4]]
// Output: 2
// Explanation: The longest chain is [1,2] -> [3,4].
// Example 2:

// Input: pairs = [[1,2],[7,8],[4,5]]
// Output: 3
// Explanation: The longest chain is [1,2] -> [4,5] -> [7,8].

//A total lis variation
//Leetcode be like- LIS hi de deta hu naam badal k... 

class Solution {

    int maxSize = Integer.MIN_VALUE;

    public int findLongestChain(int[][] pairs) {
        
        Arrays.sort(pairs, (a,b) -> {
            if(a[0] != b[0]) return a[0] - b[0];
            else return a[1] - b[1]; 
        });

        int n = pairs.length;

        int[][] dp = new int[1001][1001];
        for(int[] rows : dp){
            Arrays.fill(rows, -1);
        }

        int lengthOfLis = LIS(pairs, 0, -1, dp);
        return lengthOfLis;
    }

    int LIS(int[][] pairs, int curidx, int previdx, int[][] dp){
        if(curidx == pairs.length) return 0;

        if(dp[curidx][previdx + 1] != -1) return dp[curidx][previdx + 1];

        int notPick = LIS(pairs, curidx + 1, previdx, dp);

        int pick = 0;
        if(previdx == -1 || pairs[curidx][0] > pairs[previdx][1]){
            pick = 1 + LIS(pairs, curidx + 1, curidx, dp);
        }
        return dp[curidx][previdx + 1] = Math.max(pick, notPick);
        

    }
}