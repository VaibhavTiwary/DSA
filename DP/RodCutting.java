// Given a rod of length n(size of price) inches and an array of prices, price. price[i] denotes the 
// value of a piece of length i. Determine the maximum value obtainable by cutting up the rod and selling
// the pieces.

// Input: price[] = [1, 5, 8, 9, 10, 17, 17, 20]
// Output: 22
// Explanation: The maximum obtainable value is 22 by cutting in two pieces of lengths 2 and 6, 
// i.e., 5+17=22.

//Length array denotes different lengths of rod as price array is given for price of different lengths
//It is also similar to unbounded knapsack
//Unbounded knapsack is where we can select same item more than once.
//0/1 Knapsack
// if(length[i-1] <= j){
//     dp[i][j] = Math.max(price[i-1] + dp[i-1][j - length[i-1]], dp[i-1][j]);
// }
// else {
//     dp[i][j] = dp[i-1][j];
// }

// Unbounded Knapsack
// if(length[i-1] <= j){
//     dp[i][j] = Math.max(price[i-1] + dp[i][j - length[i-1]], dp[i-1][j]);  dp[i-1] to dp[i] as we can select same item more than once.
// }
// else {
//     dp[i][j] = dp[i-1][j];
// }










class Solution {
    public int cutRod(int[] price) {
        
        int n = price.length;
        int[] length = new int[n];
        for(int i = 0; i < n; i++){
            length[i] = i + 1;
        }
        
        int[][] dp = new int[n + 1][n + 1];
        
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= n; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
            }
        }
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(length[i-1] <= j){
                    dp[i][j] = Math.max(price[i-1] + dp[i][j - length[i-1]], dp[i-1][j]);
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][n];
    }
}