//GFG POTD

// Given a sorted integer array arr[] consisting of distinct elements, where some elements of the array
//  are moved to either of the adjacent positions, i.e. arr[i] may be present at arr[i-1] or arr[i+1].
// Given an integer target.  You have to return the index ( 0-based ) of the target in the array.
//  If target is not present return -1.

// Examples:

// Input: arr[] = [10, 3, 40, 20, 50, 80, 70], target = 40
// Output: 2
// Explanation: Index of 40 in the given array is 2.

// Binary Search Setup:
// The binary search is set up with left and right pointers.

// Checking the Middle Element and Its Neighbors:
// If the element at arr[mid] is equal to the target, return the index mid.
// Check the neighbors (arr[mid-1] and arr[mid+1]). If the target is at either of the adjacent positions, return the respective index.

// Search Direction:
// If the middle element is greater than the target, search the left half (right = mid - 2)
//  because you are guaranteed that the array is nearly sorted and any element could only be off by 
//  one position.
// If the middle element is less than the target, search the right half (left = mid + 2).

class Solution {
    public int findTarget(int arr[], int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (right >= left) {
            int mid = left + (right - left) / 2;
            
            if(arr[mid] == target) return mid;
            
            if(mid > 0 && arr[mid-1] == target) return mid - 1;
            if (mid < arr.length - 1 && arr[mid + 1] == target) {
                return mid + 1;
            }
            
            if(arr[mid] > target) right = mid - 2;
            else left = mid + 2;
        }
        
        return -1; 
    }
}