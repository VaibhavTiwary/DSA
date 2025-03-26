// You are given a 2D integer grid of size m x n and an integer x. In one operation, you can add x to
//  or subtract x from any element in the grid.

// A uni-value grid is a grid where all the elements of it are equal.

// Return the minimum number of operations to make the grid uni-value. If it is not possible, return -1.

 

// Example 1:


// Input: grid = [[2,4],[6,8]], x = 2
// Output: 4
// Explanation: We can make every element equal to 4 by doing the following: 
// - Add x to 2 once.
// - Subtract x from 6 once.
// - Subtract x from 8 twice.
// A total of 4 operations were used.

class Solution {
    public int minOperations(int[][] grid, int x) {
        int n = grid.length;

        ArrayList <Integer> list = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                list.add(grid[i][j]);
            }
        }
        if(list.size() == 1) return 0;

        Collections.sort(list);

    //If our any element gives different remainder then we can never make all element equal
        int temp = list.get(0) % x;
        for(int i = 1; i < list.size(); i++){      
            if(list.get(i) % x != temp) return -1;
        }

        int size = list.size();
        int target = list.get(size / 2);  //We will make all element equal to target
        int count = 0;

        for(int i = 0; i < list.size(); i++){
            int diff = Math.abs(list.get(i) - target);
            count += (diff / x);
        }
        return count;


        
    }


}