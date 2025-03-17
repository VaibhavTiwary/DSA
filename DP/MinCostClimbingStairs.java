// You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

// You can either start from the step with index 0, or the step with index 1.

// Return the minimum cost to reach the top of the floor.

 

// Example 1:

// Input: cost = [10,15,20]
// Output: 15
// Explanation: You will start at index 1.
// - Pay 15 and climb two steps to reach the top.
// The total cost is 15.

//RECURSIVE SOLUTION
class Solution {
    static int minCostClimbingStairs(int[] cost) {
        
        return Math.min(solve(cost, 0), solve(cost, 1));
    }
    
    static int solve(int[] cost, int start){
        if(start >= cost.length){
            return 0;
        }
        
        return cost[start] + Math.min(solve(cost, start + 1), 
                                      solve(cost, start + 2));
    }
};


//MEMOIZATION
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        int n = cost.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return Math.min(solve(cost, 0, dp), solve(cost, 1, dp));
    }
    int solve(int[] cost, int start, int[] dp){
        if(start >= cost.length){
            return 0;
        }
        if(dp[start] != -1) return dp[start];
        
        dp[start] = cost[start] + Math.min(solve(cost, start + 1, dp), 
                                      solve(cost, start + 2, dp));
                                      
        return dp[start];
    }
}

// BOTTOM-UP
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1]; // Store minimum cost to reach each step

        for (int i = 2; i <= n; i++) {
            int costFromOneStep = dp[i - 1] + cost[i - 1]; // Coming from i-1
            int costFromTwoSteps = dp[i - 2] + cost[i - 2]; // Coming from i-2
            dp[i] = Math.min(costFromOneStep, costFromTwoSteps);
        }

        return dp[n]; // Minimum cost to reach the top
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] cost = {10, 15, 20};
        System.out.println(sol.minCostClimbingStairs(cost)); // Output: 15
    }
}
