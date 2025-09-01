// There are n bulbs that are initially off. You first turn on all the bulbs, then you turn off every second bulb.

// On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on).
//  For the ith round, you toggle every i bulb. For the nth round, you only toggle the last bulb.

// Return the number of bulbs that are on after n rounds.

 

// Example 1:


// Input: n = 3
// Output: 1
// Explanation: At first, the three bulbs are [off, off, off].
// After the first round, the three bulbs are [on, on, on].
// After the second round, the three bulbs are [on, off, on].
// After the third round, the three bulbs are [on, off, off]. 
// So you should return 1 because there is only one bulb is on.


class Solution {
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);

    }
}

// Ex- n = 9
// Round 0: 0 0 0 0 0 0 0 0 0
// Round 1: 1 1 1 1 1 1 1 1 1
// Round 2: 1 0 1 0 1 0 1 0 1
// Round 3: 1 0 0 0 1 1 1 0 0
// Round 4: 1 0 0 1 1 1 1 1 0
// Round 5: 1 0 0 1 0 1 1 1 0
// Round 6: 1 0 0 1 0 0 1 1 0
// Round 7: 1 0 0 1 0 0 0 1 0
// Round 8: 1 0 0 1 0 0 0 0 0
// Round 9: 1 0 0 1 0 0 0 0 1

// Step 1: When is a bulb toggled?

// Bulb k is toggled in round i if and only if i divides k.
// (Because in round i we toggle every i-th bulb.)
// Ex- for bulb 3 it will be toggled in round i if i divides 3 i.e bulb 3 is toggled in 
// round 1 and 3
// So total toggles of bulb k = number of divisors of k.

// Step 2: When is a bulb ON at the end?

// -Bulb starts OFF.
// -A bulb is ON if it is toggled odd number of times.
// -So: we need bulbs whose number of divisors is odd.


// Step 3: Which numbers have odd number of divisors?

// Only perfect squares have odd number of divisors.

// Why?
// Divisors usually come in pairs (d, k/d).

// Only when d = k/d (i.e., k is a perfect square) do we get an unpaired divisor → odd count. b 