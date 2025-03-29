// You are given a boolean expression s containing
//     'T' ---> true
//     'F' ---> false 
// and following operators between symbols
//    &   ---> boolean AND
//     |   ---> boolean OR
//    ^   ---> boolean XOR
// Count the number of ways we can parenthesize the expression so that the value of expression evaluates 
// to true.

// Note: The answer is guaranteed to fit within a 32-bit integer.

// Examples:

// Input: s = "T|T&F^T"
// Output: 4
// Explaination: The expression evaluates to true in 4 ways: ((T|T)&(F^T)), (T|(T&(F^T))), (((T|T)&F)^T) 
// and (T|((T&F)^T)).


// Time Complexity: O(n³)

// Space Complexity: O(n²)

class Solution {
    static HashMap<String, Integer> dp;
    
    static int countWays(String s) {
       dp = new HashMap<>();
       int n = s.length();
       return solve(s, 0, n - 1, true);
        
    }
    static int solve(String s, int i, int j, boolean isTrue) {
        if (i > j) return 0;
        if (i == j) {
            if (isTrue) return (s.charAt(i) == 'T') ? 1 : 0;
            else return (s.charAt(i) == 'F') ? 1 : 0;
        }

        // Created a unique key for the map
        String key = i + "_" + j + "_" + isTrue;

        // Return if already exist in the map
        if (dp.containsKey(key)) return dp.get(key);

        int ways = 0;
        for (int k = i + 1; k < j; k += 2) { // Operators are at odd indices
            int leftTrue = solve(s, i, k - 1, true);
            int leftFalse = solve(s, i, k - 1, false);
            int rightTrue = solve(s, k + 1, j, true);
            int rightFalse = solve(s, k + 1, j, false);

            if (s.charAt(k) == '&') {
                if (isTrue) ways += leftTrue * rightTrue;
                else ways += (leftFalse * rightFalse) + (leftTrue * rightFalse) + (leftFalse * rightTrue);
            } else if (s.charAt(k) == '|') {
                if (isTrue) ways += (leftTrue * rightTrue) + (leftTrue * rightFalse) + (leftFalse * rightTrue);
                else ways += leftFalse * rightFalse;
            } else if (s.charAt(k) == '^') {
                if (isTrue) ways += (leftTrue * rightFalse) + (leftFalse * rightTrue);
                else ways += (leftTrue * rightTrue) + (leftFalse * rightFalse);
            }
        }

        // Stored the result in the map
        dp.put(key, ways);
        return ways;
    }
}