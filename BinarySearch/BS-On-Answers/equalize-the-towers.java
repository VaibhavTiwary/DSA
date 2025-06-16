// You are given an array heights[] representing the heights of towers and another array cost[] 
// where each element represents the cost of modifying the height of respective tower.

// The goal is to make all towers of same height by either adding or removing blocks from each 
// tower.
// Modifying the height of tower (add or remove) 'i' by 1 unit costs cost[i].
// Return the minimum cost to equalize the heights of all towers.

// Examples:

// Input: heights[] = [1, 2, 3], cost[] = [10, 100, 1000]
// Output: 120
// Explanation: The heights can be equalized by either "Removing one block from 3 and adding one in 1"
//  or "Adding two blocks in 1 and adding one in 2". Since the cost of operation in tower 3 is 1000, 
//  the first process would yield 1010 while the second one yields 120.


class Solution {
    public int minCost(int[] heights, int[] cost) {
        
        int max = heights[0];
        int min = heights[0];
        
        int n = heights.length;
        
        for(int i = 1; i < n; i++){
            max = Math.max(max, heights[i]);
            min = Math.min(min, heights[i]);
        }
        
        int low = min;
        int high = max;
        
        while(high > low){
            int mid = (low + high)/2;
            int nextMid = mid + 1;
            
            int price = 0;
            int nprice = 0;
            
            for(int i = 0; i < n; i++){
                int diff = Math.abs(mid - heights[i]);
                price += (diff * cost[i]);
                int diff2 = Math.abs(nextMid - heights[i]);
                nprice += (diff2 * cost[i]);
            }
            
            if(price <= nprice){
                high = mid;
            }
            else {
                low = mid + 1;
            }
            
        }
        
        int finalCost = 0;
        for(int i = 0; i < n; i++){
            finalCost += Math.abs(low - heights[i]) * cost[i];
        }
        
        return finalCost;        
    }
}
