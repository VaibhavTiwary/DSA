// Given an array arr[], partition it into two subsets(possibly empty) such that each element must belong 
// to only one subset. Let the sum of the elements of these two subsets be sum1 and sum2. Given a 
// difference d, count the number of partitions in which sum1 is greater than or equal to sum2 and the 
// difference between sum1 and sum2 is equal to d. 

// Input: arr[] =  [5, 2, 6, 4], d = 3
// Output: 1
// Explanation: There is only one possible partition of this array. Partition : {6, 4}, {5, 2}.
//  The subset difference between subset sum is: (6 + 4) - (5 + 2) = 3

// sum1 + sum2 = d
// sum1 + sum2 = sum of arr elements
// By simplifying it we will get...
// 2sum1 = d + sum.
// sum1 = (d + sum)/2;
// d + sum should be even otherwise sum1 will be not an integer.
// we need to handle case if that is odd

// Now we just need to find count of subset with sum = sum1





class Solution {
    int countPartitions(int[] arr, int d) {
        
        int n = arr.length;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += arr[i];
        }
        
        if((sum + d) % 2 != 0){
            return 0;
        }
        
        int target = (sum + d)/2;
        
        int[][] dp = new int[n+1][target+1];
        
        for (int i = 0; i <= n; i++){
            dp[i][0] = 1;
        }
        for (int j = 1; j <= target; j++){
            dp[0][j] = 0;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                if (arr[i-1] <= j) {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i-1]];
                } 
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[n][target];
    }
}