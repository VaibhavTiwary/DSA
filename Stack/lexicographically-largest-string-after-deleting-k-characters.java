// Given a string s consisting of lowercase English letters and an integer k, your task is to remove
//  exactly k characters from the string. The resulting string must be the largest possible in 
//  lexicographical  order, while maintain the relative order of the remaining characters.

// Examples:
// Input: s = "ritz", k = 2
// Output: tz 
// Explaination: By removing two characters in all possible ways,
//  we get: "ri", "rt", "rz", "it", "iz", and "tz". Among these, "tz" is lexicographically 
//  largest string.
// Input: s = "zebra", k = 3
// Output: zr 
// Explaination: Removing "e", "b", and "a" results in "zr", which is lexicographically largest string.


class Solution {
    public static String maxSubseq(String s, int k) {
        // code here
        Stack <Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            // Remove smaller characters from the top of the stack if we still can
            while (!stack.isEmpty() && k > 0 && stack.peek() < c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        // If we still need to remove characters, remove from the end (top of stack)
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        // Build the result from the stack (reverse the order)
        StringBuilder result = new StringBuilder();
        for (char ch : stack) {
            result.append(ch);
        }
        
        return result.toString();
    }
}