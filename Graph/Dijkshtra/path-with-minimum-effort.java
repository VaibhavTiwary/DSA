// You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns,
//  where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell,
//   (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). 
//   You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.

// A route's effort is the maximum absolute difference in heights between two consecutive cells of the
// route.

// Return the minimum effort required to travel from the top-left cell to the bottom-right cell.

 

// Example 1:



// Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
// Output: 2
// Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.
// This is better than the route of [1,2,2,2,5], where the maximum absolute difference is 3.

//We need to fing maxm abs diff in each path
//Then from all those maxms need to return minimum.


class Solution {
    class Pair{
        int diff;
        int row;
        int col;

        Pair(int diff, int row, int col){
            this.diff = diff;
            this.row = row;
            this.col = col;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        
        int m = heights.length;
        int n = heights[0].length;

        int[][] diffs = new int[m][n];
        for (int[] row : diffs) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<Pair> minheap = new PriorityQueue<>((a, b) -> a.diff - b.diff);
        minheap.add(new Pair(0, 0, 0));
        diffs[0][0] = 0;

        int[] drow = {-1, 1, 0, 0};
        int[] dcol = {0, 0, -1, 1};

        while(!minheap.isEmpty()){
            Pair it = minheap.poll();
            int diff = it.diff;
            int row = it.row;
            int col = it.col;

            if(row == m - 1 && col == n-1){
                return diff;
            }

            for(int i = 0; i < 4; i++){
                int nrow = row + drow[i];
                int ncol = col + dcol[i];
                if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n){
                    int curdif = Math.abs(heights[nrow][ncol] - heights[row][col]);
                    int maxdif = Math.max(curdif, diff);

                    if (maxdif < diffs[nrow][ncol]) {
                        diffs[nrow][ncol] = maxdif;
                        minheap.add(new Pair(maxdif, nrow, ncol));
                    }

                    
                }
            }


        }
        return 0;

    }
}