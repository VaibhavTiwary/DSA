// L-3085
// You are given a string word and an integer k.

// We consider word to be k-special if |freq(word[i]) - freq(word[j])| <= k for all indices i and j 
// in the string.

// Here, freq(x) denotes the frequency of the character x in word, and |y| denotes the absolute value
//  of y.

// Return the minimum number of characters you need to delete to make word k-special.


// ✔️ Choose every frequency as possible "minFreq".
// ✔️ Adjust others to fit the range [minFreq, minFreq + k].
// ✔️ Track total deletions needed.
// ✔️ Return the minimum possible deletions from all these options.



class Solution {
    public int minimumDeletions(String word, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (char ch : word.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        List<Integer> freq = new ArrayList<>(map.values());
        Collections.sort(freq);
        
        int ans = Integer.MAX_VALUE;
        int n = freq.size();
        
        // Try every possible "min freq" as the base
        for (int i = 0; i < n; i++) {
            int minFreq = freq.get(i);
            int maxAllowed = minFreq + k;
            int deletions = 0;
            
            for (int j = 0; j < n; j++) {
                if (freq.get(j) < minFreq) {
                    // Remove all if freq less than minFreq
                    deletions += freq.get(j);
                } else if (freq.get(j) > maxAllowed) {
                    // Remove extra to bring freq down to maxAllowed
                    deletions += freq.get(j) - maxAllowed;
                }
            }
            
            ans = Math.min(ans, deletions);
        }
        
        return ans;
    }
}
