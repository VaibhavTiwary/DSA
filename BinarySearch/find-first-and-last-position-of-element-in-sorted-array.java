// Given an array of integers nums sorted in non-decreasing order, find the starting and ending position
//  of a given target value.

// If target is not found in the array, return [-1, -1].

// You must write an algorithm with O(log n) runtime complexity.

 

// Example 1:

// Input: nums = [5,7,7,8,8,10], target = 8
// Output: [3,4]

// TC- O(log n)


class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        return result;
    }
    private static int findFirst(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int firstPos = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                firstPos = mid;
                high = mid - 1; // Search on the left side for the first occurrence
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return firstPos;
    }

    // Helper method to find the last occurrence of target
    private static int findLast(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int lastPos = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                lastPos = mid;
                low = mid + 1; // Search on the right side for the last occurrence
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return lastPos;
    }
}