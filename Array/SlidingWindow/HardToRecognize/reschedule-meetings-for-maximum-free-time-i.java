// You are given an integer eventTime denoting the duration of an event, where the event occurs from time t = 0 to time t = eventTime.

// You are also given two integer arrays startTime and endTime, each of length n. 
// These represent the start and end time of n non-overlapping meetings, where the ith meeting occurs 
// during the time [startTime[i], endTime[i]].

// You can reschedule at most k meetings by moving their start time while maintaining the same duration,
//  to maximize the longest continuous period of free time during the event.

// The relative order of all the meetings should stay the same and they should remain non-overlapping.

// Return the maximum amount of free time possible after rearranging the meetings.

// Note that the meetings can not be rescheduled to a time outside the event.

 

// Example 1:

// Input: eventTime = 5, k = 1, startTime = [1,3], endTime = [2,5]

// Output: 2


class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        
        List<Integer> free = new ArrayList<>();

        int curStart = 0;
        for(int i = 0; i < startTime.length; i++){
            int freeSpace = startTime[i] - curStart;
            free.add(freeSpace);
            curStart = endTime[i];
        }

        free.add(eventTime - curStart); //last free space

        int window = k + 1;  //if we will do k shifts then we will have k+1 free spaces
        //if we do 1 shift then 2 free spaces will be available.

        //Stored all the free spaces in the list.
        //Now we need to find the maximum sum of k+1 size subarray as we will get k+1 free spaces
        //and among all we need to get max

        //Apply sliding window to find max sum of k+1 size subarray.

        int j = 0;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int i = 0; i < free.size(); i++){
            sum += free.get(i);

            if(i-j+1 == k+1){
                maxSum = Math.max(sum, maxSum);

                sum -= free.get(j);
                j++;
            }
        }
        return maxSum;

    }
}

// Time:      0     2     4     6     10    12    15    20
//            |-----|#####|-----|#####|-----|#####|-----|
// Segment:   0-2     2-4   4-6   6-10 10-12 12-15 15-20

// # represents busy slot and --- represents free slot
// if lets say i shifted 1 meeting i.e (2-4) to (0-2) so now we got free slots from (2-6)
// so by shifting 1 meeting we got 2 free spaces i.e 0-2 and 4-6 as 2-6

// Use a sliding window of size k + 1 over the list of free segments to find the maximum total free time achievable after shifting k meetings.