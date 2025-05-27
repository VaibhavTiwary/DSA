// Given an integer s represented as a string, the task is to get the sum of all possible sub-strings of this string.

// Note: The number may have leading zeros.
// It is guaranteed that the total sum will fit within a 32-bit signed integer.

// Examples:

// Input: s = "6759"
// Output: 8421
// Explanation:
// Sum = 6 + 7 + 5 + 9 + 67 + 75 + 59 + 675 + 759 + 6759 = 8421

//For smaller inputs
class Solution {
    public static int sumSubstrings(String s) {
        
        int sum = 0;
        
        for(int i = 0; i < s.length(); i++){
            for(int j = i; j < s.length(); j++){
                String substring = s.substring(i, j + 1);
                int substr = Integer.parseInt(substring);
                sum += substr;
            }
        }
        return sum;
        
    }
}


//O(N)
class Solution {
    public static int sumSubstrings(String s) {
        int n = s.length();
        long res = 0;
        long prev = 0;
        int mod = 1_000_000_007;  // optional if needed for large inputs

        for (int i = 0; i < n; i++) {
            int num = s.charAt(i) - '0';
            prev = (prev * 10 + (long)(i + 1) * num);
            res += prev;
        }

        return (int) res;
    }
}
