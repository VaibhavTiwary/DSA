// A digit string is good if the digits (0-indexed) at even indices are even and the digits at odd 
// indices are prime (2, 3, 5, or 7).

// For example, "2582" is good because the digits (2 and 8) at even positions are even and the digits
//  (5 and 2) at odd positions are prime. However, "3245" is not good because 3 is at an even index but 
//  is not even.
// Given an integer n, return the total number of good digit strings of length n. Since the answer may be 
// large, return it modulo 109 + 7.

// A digit string is a string consisting of digits 0 through 9 that may contain leading zeros.

 

// Example 1:

// Input: n = 1
// Output: 5
// Explanation: The good numbers of length 1 are "0", "2", "4", "6", "8".
// Example 2:

// Input: n = 4
// Output: 400
// Example 3:

// Input: n = 50
// Output: 564908303

//We have used binary exponentiation for solving this question ans we will have to deal with large powers 
// which will be inefficient if we calculate the power normally i.e recursively 
// Binary exponentiation calculates a^b in O(log b) time.



class Solution {
    public int countGoodNumbers(long n) {
        
        int MOD = 1000000007;
        long odd = n / 2;
        long even = n - odd;
        
        long oddCount = power(4, odd, MOD);
        long evenCount = power(5, even, MOD);

        return (int) ((oddCount * evenCount) % MOD);
    }

    long power(int base, long exp, int MOD){
        if(exp == 0) return 1;
        long half = power(base, exp/2, MOD);
        if(exp % 2 == 0) return ((half * half) % MOD);
        return ((half * half * base) % MOD);
    }
}