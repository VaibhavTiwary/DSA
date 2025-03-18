// Given an integer array coins[ ] representing different denominations of currency and an integer sum, 
// find the number of ways you can make sum by using different combinations from coins[ ]. 
// Note: Assume that you have an infinite supply of each type of coin. Therefore, you can use any coin 
// as many times as you want.
// Answers are guaranteed to fit into a 32-bit integer. 


//Same as subset sum



class Solution {
    public int count(int coins[], int sum) {
        
        int n = coins.length;
        
        int[][] dp = new int[n + 1][sum + 1];
        
        for(int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for(int j = 1; j <= sum; j++) {
            dp[0][j] = 0;
        }
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= sum; j++){
                if(coins[i-1] <= j){
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[n][sum];

    }
}



//Coin change ii

// You are given an integer array coins representing coins of different denominations and an integer 
// amount representing a total amount of money.

// Return the fewest number of coins that you need to make up that amount. If that amount of money 
// cannot be made up by any combination of the coins, return -1.

// You may assume that you have an infinite number of each kind of coin.

//Here we are filling the first row separately by diviing the amount with first element of coins array
// as for first row the length of array would be 1


class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];

        for (int j = 1; j <= amount; j++) {
            dp[0][j] = Integer.MAX_VALUE - 1;  
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;  
        }

        for(int j = 1; j <= amount; j++){
            if(j % coins[0] == 0){
                dp[1][j] = j / coins[0];
            }
            else {
                dp[1][j] = Integer.MAX_VALUE - 1;
            }
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1] <= j) {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        if(dp[n][amount] == Integer.MAX_VALUE - 1){
            return -1;
        }
        return dp[n][amount];

    }
}
