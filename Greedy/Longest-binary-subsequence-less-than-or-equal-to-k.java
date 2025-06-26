// You are given a binary string s and a positive integer k.

// Return the length of the longest subsequence of s that makes up a binary number less than or 
// equal to k.

// Note:

// The subsequence can contain leading zeroes.
// The empty string is considered to be equal to 0.
// A subsequence is a string that can be derived from another string by deleting some or no 
// characters without changing the order of the remaining characters.
 

// Example 1:

// Input: s = "1001010", k = 5
// Output: 5
// Explanation: The longest subsequence of s that makes up a binary number less than or equal to 5 
// is "00010", as this number is equal to 2 in decimal.
// Note that "00100" and "00101" are also possible, which are equal to 4 and 5 in decimal, 
// respectively.
// The length of this subsequence is 5, so 5 is returned.
// Example 2:

// Input: s = "00101001", k = 1
// Output: 6
// Explanation: "000001" is the longest subsequence of s that makes up a binary number less than or
//  equal to 1, as this number is equal to 1 in decimal.
// The length of this subsequence is 6, so 6 is returned.


// All '0's are always safe to include. So we count them up front.

// For each '1', you compute what value it adds.(from right)

// E.g., the rightmost '1' adds 2^0 = 1, then 2^1 = 2, etc.

// You keep including '1's as long as their total value ≤ k.

// Each valid '1' is treated like a '0' — added to the count.
// This gives:

// number of '0's (always included)

// + number of '1's we could safely include from the right


class Solution {
    public int longestSubsequence(String s, int k) {
        
        int n = s.length();
        int zero = 0;

        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '0'){
                zero++;
            }
        }

        int cnt = 0;
        int val = 0;
        for(int i = n-1; i >= 0; i--){
            if(s.charAt(i) == '1'){
                val += Math.pow(2, cnt);
                if(val <= k) zero++;
                else break;
            }
            cnt++;
        }

        return zero;
    }
}