// A Slight Variation of variable size sliding window and here we need to play with 2 windows 



// You are given a string word and a non-negative integer k.

// Return the total number of substrings of word that contain every vowel ('a', 'e', 'i', 'o', and 'u') 
// at least once and exactly k consonants.

// input: word = "ieaouqqieaouqq", k = 1

// Output: 3

// Explanation:
// The substrings with every vowel and one consonant are:

// word[0..5], which is "ieaouq".
// word[6..11], which is "qieaou".
// word[7..12], which is "ieaouq".


// We are calculating for at least k + 1 consonants and at least k consonants.

// at least k = k, k+1, k+2....
// at least k + 1 = k + 1, k + 2 ...
// Subtract them and we will get k left. That's the main logic behind that







import java.util.HashMap;

class Solution {
    public long countOfSubstrings(String word, int k) {
        return atleast(k, word) - atleast(k+1, word);
    }

    private boolean isConsonant(char ch) {
        return (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u');
    }

    private boolean isAllVowelsPresent(HashMap<Character, Integer> map) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        for(char v : vowels){
            if(map.getOrDefault(v, 0) == 0){
                return false;
            }
        }
        return true;
    }


    private long atleast(int k, String word) {
        long count = 0;
        int curConsonant = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int n = word.length();

        for (int right = 0; right < n; right++) {
            char ch = word.charAt(right);

            // Add character to HashMap
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            // Count consonants
            if (isConsonant(ch)) {
                curConsonant++;
            }

            // Shrink the window if it has k consonants and all vowels present
            while (curConsonant >= k && isAllVowelsPresent(map)) {
                // Count all valid substrings from [left -> right] to [left -> n-1]
                count += (n - right);

                // Remove the left character from the map
                char c = word.charAt(left);
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    map.remove(c);
                }

                // Reduce consonant count if left character was a consonant
                if (isConsonant(c)) {
                    curConsonant--;
                }

                left++;
            }
        }

        return count;
    }
}
