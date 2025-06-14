// You are given a sorted array arr[] of unique integers, an integer k, and a target value x. 
// Return exactly k elements from the array closest to x, excluding x if it exists.

// An element a is closer to x than b if:


// |a - x| < |b - x|, or
// |a - x| == |b - x| and a > b (i.e., prefer the larger element if tied)


// Return the k closest elements in order of closeness.

// Examples:

// Input: arr[] = [1, 3, 4, 10, 12], k = 2, x = 4
// Output: 3 1
// Explanation: 4 is excluded, Closest elements to 4 are: 3 (1), 1 (3). So, the 2 closest 
// elements are: 3 1
// Input: arr[] = [12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56], k = 4, x = 35
// Output: 39 30 42 45
// Explanation: First closest element to 35 is 39.


class Solution {
    public int[] printKClosest(int[] arr, int k, int x) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) return a[0] - b[0];
                return b[1] - a[1]; 
            }
        );

        for (int num : arr) {
            if (num != x) {
                minHeap.add(new int[]{Math.abs(num - x), num});
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll()[1];
        }

        return result;
    }
}
