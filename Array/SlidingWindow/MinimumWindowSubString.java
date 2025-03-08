
// L-76
// Given two strings s and t of lengths m and n respectively, return the minimum window substring of s 
// such that every character in t (including duplicates) is included in the window. 
// If there is no such substring, return the empty string "".

// The testcases will be generated such that the answer is unique.
// Input: s = "ADOBECODEBANC", t = "ABC"
// Output: "BANC"
// Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

class Solution {
    public String MinimumWindowSubString(String s, String t) {
        if (s.length() < t.length()) return "";
        
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int i = 0, j = 0;
        int minLength = Integer.MAX_VALUE;
        int start = 0;  
        int count = map.size(); 

        while (j < s.length()) {
            char cur = s.charAt(j);
            if (map.containsKey(cur)) {
                map.put(cur, map.get(cur) - 1);
                if (map.get(cur) == 0) {
                    count--;  
                }
            }
            
            while (count == 0) {
                if (j - i + 1 < minLength) {
                    minLength = j - i + 1;
                    start = i;
                }

                char leftChar = s.charAt(i);
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);
                    if (map.get(leftChar) > 0) {
                        count++; 
                    }
                }
                i++;
            }

            j++;
        }
        
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }
}

