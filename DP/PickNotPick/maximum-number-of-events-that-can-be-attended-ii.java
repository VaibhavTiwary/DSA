// You are given an array of events where events[i] = [startDayi, endDayi, valuei]. The ith event starts at startDayi and ends at endDayi, and if you attend this event, you will receive a value of valuei. You are also given an integer k which represents the maximum number of events you can attend.

// You can only attend one event at a time. If you choose to attend an event, you must attend the entire event. Note that the end day is inclusive: that is, you cannot attend two events where one of them starts and the other ends on the same day.

// Return the maximum sum of values that you can receive by attending events.

 

// Example 1:



// Input: events = [[1,2,4],[3,4,3],[2,3,1]], k = 2
// Output: 7
// Explanation: Choose the green events, 0 and 1 (0-indexed) for a total value of 4 + 3 = 7.

// dp(i, k) = max value we can get by attending up to k events starting from index i
// At each step, we have 2 choices:

// Skip the current event → move to the next index: dp(i + 1, k)

// Attend the current event:

// Reduce k by 1
// Add its value
// Jump to the next non-overlapping event (using binary search)

// 3. Binary Search
// When we choose to attend an event at index i, we must find the next event that starts after the current event ends (i.e., events[i][1]).

// We perform a binary search to find this next index efficiently


// Time Complexity: O(n * k * log n)

// n: number of events
// k: number of events we can attend
// log n due to binary search for next event

// Space Complexity: O(n * k) for memoization table

class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        int n = events.length;
        Integer[][] memo = new Integer[n][k + 1];

        return dfs(0, k, events, memo);
    }

    private int dfs(int i, int k, int[][] events, Integer[][] memo) {
        if (i == events.length || k == 0) return 0;
        if (memo[i][k] != null) return memo[i][k];

        // Option 1: Skip current event
        int skip = dfs(i + 1, k, events, memo);

        // Option 2: Attend current event
        int nextIndex = findNext(events, events[i][1]);
        int take = events[i][2] + dfs(nextIndex, k - 1, events, memo);

        return memo[i][k] = Math.max(skip, take);
    }

    // Binary search for the next event that starts AFTER current endDay
    private int findNext(int[][] events, int endDay) {
        int low = 0, high = events.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (events[mid][0] <= endDay) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}