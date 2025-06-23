// A k-mirror number is a positive integer without leading zeros that reads the same both forward 
// and backward in base-10 as well as in base-k.

// For example, 9 is a 2-mirror number. The representation of 9 in base-10 and base-2 are 9 and 
// 1001 respectively, which read the same both forward and backward.
// On the contrary, 4 is not a 2-mirror number. The representation of 4 in base-2 is 100,
//  which does not read the same both forward and backward.
// Given the base k and the number n, return the sum of the n smallest k-mirror numbers.



// Example 1:

// Input: k = 2, n = 5
// Output: 25
// Explanation:
// The 5 smallest 2-mirror numbers and their representations in base-2 are listed as follows:
//   base-10    base-2
//     1          1
//     3          11
//     5          101
//     7          111
//     9          1001
// Their sum = 1 + 3 + 5 + 7 + 9 = 25. 
// Example 2:

// Input: k = 3, n = 7
// Output: 499
// Explanation:
// The 7 smallest 3-mirror numbers are and their representations in base-3 are listed as follows:
//   base-10    base-3
//     1          1
//     2          2
//     4          11
//     8          22
//     121        11111
//     151        12121
//     212        21212
// Their sum = 1 + 2 + 4 + 8 + 121 + 151 + 212 = 499.


class Solution {
        
    // Check if a string is a palindrome
    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        
        while (left <= right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    // Convert a number to base-k string representation
    private String convertToBaseK(long num, int k) {
        if (num == 0) return "0";
        
        StringBuilder res = new StringBuilder();
        while (num > 0) {
            res.append(num % k);
            num /= k;
        }
        return res.toString();
    }

    public long kMirror(int k, int n) {
        long sum = 0;
        int length = 1;

        while (n > 0) {
            int halfLength = (length + 1) / 2;  //works noth for even and odd length

            //if halflength = 3 , first number would be 100 i.e 10(3-1)
            long minNum = (long)Math.pow(10, halfLength - 1); //the frst number of halflength length
            long maxNum = (long)Math.pow(10, halfLength) - 1;

            for (long num = minNum; num <= maxNum; num++) {
                String firstHalf = Long.toString(num);
                String secondHalf = new StringBuilder(firstHalf).reverse().toString();
                
                String fullPalindrome;
                if (length % 2 == 0) {
                    fullPalindrome = firstHalf + secondHalf;
                } else {
                    fullPalindrome = firstHalf + secondHalf.substring(1);
                }

                long palNum = Long.parseLong(fullPalindrome);
                String baseK = convertToBaseK(palNum, k);

                if (isPalindrome(baseK)) {
                    sum += palNum;
                    n--;
                    if (n == 0) {
                        return sum;
                    }
                }
            }
            length++;
        }
        return sum;
    }
}

    