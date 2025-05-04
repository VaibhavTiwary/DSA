// Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j] = [c, d] if and 
// only if either (a == c and b == d), or (a == d and b == c) - that is, one domino can be rotated 
// to be equal to another domino.

// Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length, and dominoes[i] is 
// equivalent to dominoes[j].

 

// Example 1:

// Input: dominoes = [[1,2],[2,1],[3,4],[5,6]]
// Output: 1
// Example 2:

// Input: dominoes = [[1,2],[1,2],[1,1],[1,2],[2,2]]
// Output: 3

//need to check for (1,2) and (2,1) so we found smaller and larger among them as that would be same
//and then calculated a number -> int num = (small * 10) + large
//num will be same for bothcases and then put in hashmap.

class Solution {

    public int numEquivDominoPairs(int[][] dominoes) {
        
        HashMap <Integer, Integer> map = new HashMap<>();

        for(int[] dominoe : dominoes){
            int small = Math.min(dominoe[0], dominoe[1]);
            int large = Math.max(dominoe[0], dominoe[1]);
            int num = (small * 10) + large;
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res = 0;

        for (int count : map.values()) {
            if (count > 1) {
                res += (count * (count - 1)) / 2;
            }
        }
        return res;

        
    }
}
