// Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, 
// or -1 if needle is not part of haystack.

 

// Example 1:

// Input: haystack = "sadbutsad", needle = "sad"
// Output: 0
// Explanation: "sad" occurs at index 0 and 6.
// The first occurrence is at index 0, so we return 0.


class Solution {
    public int strStr(String haystack, String needle) {
        
        int i = 0;
        int j = 0;
        int start = 0;

        while(i < haystack.length()){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
                if(j == needle.length()){
                    return i - needle.length();
                }
            }
            else {
                i = i - j + 1;
                j = 0;
            }
        }
        return -1;
    }
}