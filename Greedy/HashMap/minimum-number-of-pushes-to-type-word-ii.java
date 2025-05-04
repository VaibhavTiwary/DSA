// L-3016

// You are given a string word containing lowercase English letters.

// Telephone keypads have keys mapped with distinct collections of lowercase English letters,
//  which can be used to form words by pushing them. For example, the key 2 is mapped with ["a","b","c"], 
//  we need to push the key one time to type "a", two times to type "b", and three times to type "c" .

// It is allowed to remap the keys numbered 2 to 9 to distinct collections of letters. The keys can be
//  remapped to any amount of letters, but each letter must be mapped to exactly one key. 
//  You need to find the minimum number of times the keys will be pushed to type the string word.

// Return the minimum number of pushes needed to type word after remapping the keys.

// An example mapping of letters to keys on a telephone keypad is given below. Note that 1, *, #, and
//  0 do not map to any letters.


 

// Example 1:


// Input: word = "abcde"
// Output: 5
// Explanation: The remapped keypad given in the image provides the minimum cost.
// "a" -> one push on key 2
// "b" -> one push on key 3
// "c" -> one push on key 4
// "d" -> one push on key 5
// "e" -> one push on key 6
// Total cost is 1 + 1 + 1 + 1 + 1 = 5.
// It can be shown that no other mapping can provide a lower cost.
// Example 2:


// Input: word = "xyzxyzxyzxyz"
// Output: 12

//we will try to keep those characters at start that has highest frequencies.
// so we sort the map in descending order
//we have 8 options i.e 2-9 so used count to check we are in first round or second.
//for second round, we will require 2 pushes so for count between 9 and 16 we can find ceil or (count+7)/8;



class Solution {
    public int minimumPushes(String word) {

        int n = word.length();

        HashMap <Character, Integer> map = new HashMap<>();
        for(char ch : word.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int size = map.size();
        if(size <= 8) return n;

        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((a, b) -> b.getValue() - a.getValue());
        
        int count = 0;
        int pushes = 0;

        for(Map.Entry<Character, Integer> entry : entryList){
            count++;
            int value = entry.getValue();
            // pushes += (value * ((int)Math.ceil(count / 8.0)));
            pushes += (value * ((count + 7) / 8));

        }
        return pushes;


    }
}