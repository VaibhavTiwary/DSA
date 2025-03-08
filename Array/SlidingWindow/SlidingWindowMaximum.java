// You are given an array of integers nums, there is a sliding window of size k which is moving from the 
// very left of the array to the very right. You can only see the k numbers in the window. 
// Each time the sliding window moves right by one position.

// Return the max sliding window.

 

// Example 1:

// Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
// Output: [3,3,5,5,6,7]


// Main thing is before adding new element in deque remove all elements that is smaller than that 
// from the queue as they can never be largest of the window as we got someone larger than them.

import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];

        int n = nums.length;
        int[] ans = new int[n - k + 1]; 
        Deque<Integer> deque = new ArrayDeque<>(); 

        int i = 0, j = 0;
        
        while (j < n) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[j]) {
                deque.pollLast();
            }
            deque.addLast(j); 

            if (j - i + 1 == k) {
                ans[i] = nums[deque.peekFirst()];

                if (deque.peekFirst() == i) {
                    deque.pollFirst();
                }

                i++;

            }
            j++;
            
        }

        return ans;
    }
}
