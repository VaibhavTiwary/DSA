// You are given n identical eggs and you have access to a k-floored building from 1 to k.

// There exists a floor f where 0 <= f <= k such that any egg dropped from a floor higher than f will break,
//  and any egg dropped from or below floor f will not break.
// There are few rules given below. 

// An egg that survives a fall can be used again.
// A broken egg must be discarded.
// The effect of a fall is the same for all eggs.
// If the egg doesn't break at a certain floor, it will not break at any floor below.
// If the egg breaks on a certain floor, it will break on any floor above.
// Return the minimum number of moves you need to determine the value of f with certainty.

// Examples:

// Input: n = 2, k = 36
// Output: 8
// Explanation: In all the situations, 8 maximum moves are required to find the maximum floor. Following is the strategy to do so:
// Drop from floor 8 → If breaks, check 1-7 sequentially.
// Drop from floor 15 → If breaks, check 9-14.
// Drop from floor 21  → If breaks, check 16-20.
// Drop from floor 26 → If breaks, check 22-25.
// Drop from floor 30 → If breaks, check 27-29.
// Drop from floor 33 → If breaks, check 31-32.
// Drop from floor 35 → If breaks, check 34.
// Drop from floor 36 → Final check.

class Solution {
    static HashMap<String, Integer> dp;

    static int eggDrop(int n, int k) {
        dp = new HashMap<>();
        return solve(n, k);
    }

    private static int solve(int eggs, int floors) {
        if (floors == 0 || floors == 1) return floors; 
        if (eggs == 1) return floors;

        // Create unique key for memoization
        String key = eggs + "_" + floors;
        if (dp.containsKey(key)) return dp.get(key);

        int minAttempts = Integer.MAX_VALUE;

        int low = 1, high = floors;
        while (low <= high) {
            int mid = (low + high) / 2;

            int breakCase = solve(eggs - 1, mid - 1);  // Egg breaks, check below
            int noBreakCase = solve(eggs, floors - mid); // Egg survives, check above
            
            int worstCase = 1 + Math.max(breakCase, noBreakCase);
            minAttempts = Math.min(minAttempts, worstCase);

            // // Binary Search Optimization: Move towards the worst-case scenario
            // if (breakCase > noBreakCase) {
            //     high = mid - 1;  // Move downward
            // } else {
            //     low = mid + 1;   // Move upward
            // }
        }

        dp.put(key, minAttempts);
        return minAttempts;
    }

    
}