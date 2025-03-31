Given a sorted array arr[] and an integer x, find the index (0-based) of the largest element in arr[] 
that is less than or equal to x. This element is called the floor of x. If such an element does not 
exist, return -1.

Note: In case of multiple occurrences of ceil of x, return the index of the last occurrence.

Examples

Input: arr[] = [1, 2, 8, 10, 10, 12, 19], x = 5
Output: 1
Explanation: Largest number less than or equal to 5 is 2, whose index is 1.

//Ceil would be 8(smallest number greater than target)



class Solution {
    // Function to find the floor of x (largest element ≤ x)
    static int findFloor(long arr[], int n, long x) {
        int left = 0, right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > x) {
                right = mid - 1;  // Move left
            } else {
                left = mid + 1;  // Move right
            }
        }

        return right;  // Floor index
    }

    // Function to find the ceil of x (smallest element ≥ x)
    static int findCeil(long arr[], int n, long x) {
        int left = 0, right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < x) {
                left = mid + 1;  // Move right
            } else {
                right = mid - 1;  // Move left
            }
        }

        return left;  // Ceil index
    }

}
