// Given a string s consisting only lowercase alphabets and an integer k. 
// Find the count of all substrings of length k which have exactly k-1 distinct characters.

// Examples:

// Input: s = "abcc", k = 2
// Output: 1
// Explaination: Possible substring of length k = 2 are,
// ab : 2 distinct characters
// bc : 2 distinct characters
// cc : 1 distinct characters
// Only one valid substring so, count is equal to 1.


class Solution {
    public int substrCount(String s, int k) {
        
        int n = s.length();
        
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        
        int res = 0;
        
        while(j < n){
            
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            
            if((j-i+1) < k) j++;
            
            else if(j-i+1 == k){
                
                if(map.size() == k-1) res++;
                
                char c = s.charAt(i);
                if (map.get(c) == 1) map.remove(c);
                else map.put(c, map.get(c) - 1);
                
                i++;
                j++;
            }
            
        }
        return res;
    }
}