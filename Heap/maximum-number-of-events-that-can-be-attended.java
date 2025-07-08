// You are given an array of events where events[i] = [startDayi, endDayi]. Every event i starts at startDayi and ends at endDayi.

// You can attend an event i at any day d where startDayi <= d <= endDayi. You can only attend one event at any time d.

// Return the maximum number of events you can attend.


// Input: events = [[1,2],[2,3],[3,4]]
// Output: 3
// Explanation: You can attend all the three events.
// One way to attend them all is as shown.
// Attend the first event on day 1.
// Attend the second event on day 2.
// Attend the third event on day 3.
// Example 2:

// Input: events= [[1,2],[2,3],[3,4],[1,2]]
// Output: 4

// We want to:

// Each day, attend the event that ends earliest.

// Why? Because that leaves more future days open for longer-duration events.

// Use a min-heap to store endDays of available events
// Every day, we add all events starting today into the min-heap.

// The heap gives us the event that ends the earliest.

// We remove any events whose endDay < today (they've expired).

// Attend (poll) one event (smallest endDay) per day.

class Solution {
    public int maxEvents(int[][] events) {
        
        Arrays.sort(events, (a,b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];  
            else
                return a[1] - b[1]; 
        });

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int i = 0, res = 0, n = events.length;

        // Find the last day we need to process
        int lastDay = 0;
        for (int[] e : events) lastDay = Math.max(lastDay, e[1]);

        // Go through each day
        for (int day = 1; day <= lastDay; day++) {

            // Add events starting today
            while (i < n && events[i][0] == day) {
                minHeap.offer(events[i][1]);
                i++;
            }

            // Remove events that already expired
            while (!minHeap.isEmpty() && minHeap.peek() < day) {
                minHeap.poll();
            }

            // Attend one event
            if (!minHeap.isEmpty()) {
                minHeap.poll();
                res++;
            }
        }

        return res;
    }
}
 