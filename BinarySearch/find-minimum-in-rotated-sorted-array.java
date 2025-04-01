class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) { 
                left = mid + 1;
            } else { 
                right = mid;
            }
        }
        return nums[left];
        // return nums[right];
    }
}

//We can either return left or right because at the end loop will terminate and left will be equal 
// to right so both will point to the smallest element
