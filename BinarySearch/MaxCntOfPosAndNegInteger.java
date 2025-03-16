// Given an array nums sorted in non-decreasing order, return the maximum between the number of positive 
// integers and the number of negative integers.

// In other words, if the number of positive integers in nums is pos and the number of negative integers
//  is neg, then return the maximum of pos and neg.
// Note that 0 is neither positive nor negative.


// Example 2:

// Input: nums = [-3,-2,-1,0,0,1,2]
// Output: 3
// Explanation: There are 2 positive integers and 3 negative integers. The maximum count among them is 3.


//Normal Approach using O(N) TC
// class Solution {
//     public int maximumCount(int[] nums) {
//         int pos = 0;
//         int neg = 0;
//         for(int i = 0; i < nums.length; i++){
//             if(nums[i] < 0) neg++;
//             else if(nums[i] == 0) continue;
//             else pos++;
//         }
//         return Math.max(pos, neg);
//     }
// }

//BINARY SEARCH APPROACH

// As we have got array in sorted order so for finding number of negative elements we will find first number
// greater than or equal to 0.
// [-3,-2,-1,0,0,1,2] - if we find index of first >= 0 that is 3 then number of negative elements would be 3 - 1

// For number of positive elements we will search for first positive number i.e > 0
//  number of +ve elements would be (n - firstposindex)

class Solution {
    public int maximumCount(int[] nums) {
        //first number greater than -1 -> for neg
        // first number > 0 -> for pos
        int n = nums.length;
        int end = n-1;
        int negPos = binarySearch(nums, 0, end, -1); //log(n)
        int posPos = binarySearch(nums, negPos, end, 0); //log(n - negPos)
        int posCount = (n - posPos);
        return Math.max(negPos,posCount);
    }
    public int binarySearch(int nums[], int start, int end, int target){
        while(start<=end){
            int mid = start + (end-start)/2;
            if(nums[mid]<=target){
                start = mid+1;
            }else{
                end=mid-1;
            }
        }
        return start;   // we are setting target -1 for first >= 0. so for loop to end the sequence of 
        // pointers would be end mid start and on mid we will have target so at start we will get first >= 0
        //Same for finding first +ve we are setting target 0 so on start we will get the desired result
    }
}