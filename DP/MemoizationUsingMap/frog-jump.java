// A frog is crossing a river. The river is divided into some number of units, and at each unit, 
// there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.

// Given a list of stones positions (in units) in sorted ascending order, determine if the frog can 
// cross the river by landing on the last stone. Initially, the frog is on the first stone and assumes 
// the first jump must be 1 unit.

// If the frog's last jump was k units, its next jump must be either k - 1, k, or k + 1 units. 
// The frog can only jump in the forward direction.

 

// Example 1:

// Input: stones = [0,1,3,5,6,8,12,17]
// Output: true
// Explanation: The frog can jump to the last stone by jumping 1 unit to the 2nd stone, then 2 
// units to the 3rd stone, then 2 units to the 4th stone, then 3 units to the 6th stone, 4 units to 
// the 7th stone, and 5 units to the 8th stone.
// Example 2:

// Input: stones = [0,1,2,3,4,8,9,11]
// Output: false
// Explanation: There is no way to jump to the last stone as the gap between the 5th and 6th stone is 
// too large.

class Solution {
    HashMap<String, Boolean> dp = new HashMap<>();

    public boolean canCross(int[] stones) {
        // If the second stone is not 1, it's impossible to jump to the second stone
        if (stones[1] != 1) return false;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], i);
        }

        return solve(stones, map, 1, 1);
    }

    boolean solve(int[] stones, HashMap<Integer, Integer> map, int curStone, int lastJump) {
        if (curStone == stones[stones.length - 1]) return true;

        String state = curStone + "," + lastJump;

        // Check if this state has already been computed
        if (dp.containsKey(state)) return dp.get(state);

        // Try all 3 possible jumps: lastJump-1, lastJump, lastJump+1
        for (int nextJump = lastJump - 1; nextJump <= lastJump + 1; nextJump++) {
            if (nextJump > 0) {
                int nextStone = curStone + nextJump;

                // If the next stone exists, try to jump to it
                if (map.containsKey(nextStone)) {
                    if (solve(stones, map, nextStone, nextJump)) {
                        dp.put(state, true);  
                        return true;
                    }
                }
            }
        }

        dp.put(state, false);
        return false;
    }
}
