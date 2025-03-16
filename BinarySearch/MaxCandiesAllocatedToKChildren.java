// You are given a 0-indexed integer array candies. Each element in the array denotes a pile of candies of 
// size candies[i]. You can divide each pile into any number of sub piles, but you cannot merge two piles
//  together.

// You are also given an integer k. You should allocate piles of candies to k children such that each 
// child gets the same number of candies. Each child can be allocated candies from only one pile of 
// candies and some piles of candies may go unused.

// Return the maximum number of candies each child can get.



// Input: candies = [5,8,6], k = 3
// Output: 5
// Explanation: We can divide candies[1] into 2 piles of size 5 and 3, and candies[2] into 2 piles of size 
// 5 and 1. We now have five piles of candies of sizes 5, 5, 3, 5, and 1. We can allocate the 3 piles of 
// size 5 to 3 children. It can be proven that each child cannot receive more than 5 candie


// We are applying bin search on 1 to max[candies]
// and we will check whether we can divide equally or not.
// we are finding mid and for checking we need to divide k with all elements.

// if piles >= k then that can be a possible answer so we store that in best and check for any larger 
// number

class Solution {
    public int maximumCandies(int[] candies, long k) {

        int max = candies[0];
        for(int i = 1; i < candies.length; i++){
            max = Math.max(candies[i], max);
        }

        int low = 1;
        int high = max;
        int best = 0;
        
        while(high >= low){
            int mid = (low + high) / 2;
            long piles = 0;

            for(int i = 0; i < candies.length; i++){
                piles += (candies[i] / mid);
            }

            if(piles >= k){
                best = mid;
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return best;
    }
}