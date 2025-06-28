// You are given an integer array nums and an integer k. You want to find a subsequence of nums of 
// length k that has the largest sum.

// Return any such subsequence as an integer array of length k.

// A subsequence is an array that can be derived from another array by deleting some or no elements 
// without changing the order of the remaining elements.

 

// Example 1:

// Input: nums = [2,1,3,3], k = 2
// Output: [3,3]
// Explanation:
// The subsequence has the largest sum of 3 + 3 = 6.

class Solution {
    class Pair{
        int value;
        int index;

        Pair(int value, int index){
            this.value = value;
            this.index = index;
        }
    }
    public int[] maxSubsequence(int[] nums, int k) {
        
        int n = nums.length;
        if(n == k) return nums;

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(
            (a, b) -> b.value - a.value
        );

        for (int i = 0; i < n; i++) {
            maxHeap.offer(new Pair(nums[i], i));
        }

        List<Pair> topK = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            topK.add(maxHeap.poll());
        }
        
        //Sorting top k based on their index as we need subsequence so we have to maintain the order
        topK.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                return a.index - b.index;
            }
        });

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = topK.get(i).value;
        }

        return result;

    }
}