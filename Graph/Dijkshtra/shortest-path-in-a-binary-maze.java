// Given a n * m matrix grid where each element can either be 0 or 1. You need to find the shortest 
// distance between a given source cell to a destination cell. The path can only be created out of a cell
//  if its value is 1. 

// If the path is not possible between source cell and destination cell, then return -1.

// Note : You can move into an adjacent cell if that adjacent cell is filled with element 1. 
// Two cells are adjacent if they share a side. In other words, you can move in one of the four directions,
//  Up, Down, Left and Right. The source and destination cell are based on the zero based indexing. 
//  The destination cell should be 1.

// Example 1:

// Input:
// grid[][] = {{1, 1, 1, 1},
//             {1, 1, 0, 1},
//             {1, 1, 1, 1},
//             {1, 1, 0, 0},
//             {1, 0, 0, 1}}
// source = {0, 1}
// destination = {2, 2}
// Output:
// 3
// Explanation:
// 1 1. 1 1
// 1 1. 0 1
// 1 1. 1.1
// 1 1  0 0
// 1 0  0 1
// The dotted part in the matrix denotes the 
// shortest path from source to destination cell.

//Although shortest path is being asked but we can solve without using priority queue because distance
//is same so both in queue and pq, the dist will be in ascending order.

class Solution {
    class Pair{
        int row;
        int col;
        int dist;
        
        Pair(int row, int col, int dist){
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    int shortestPath(int[][] grid, int[] source, int[] destination) {
        
        int m = grid.length;
        int n = grid[0].length;
        
        int startrow = source[0];
        int startcol = source[1];
        int destrow = destination[0];
        int destcol = destination[1];
        
        int[][] vis = new int[m][n];
        
        if(grid[startrow][startcol] != 1 || grid[destrow][destcol] != 1) return -1;
        
        Queue <Pair> q = new LinkedList<>();
        q.add(new Pair(startrow, startcol, 0));
        
        vis[startrow][startcol] = 1;
        
        int[] drow = {-1, 1, 0, 0};
        int[] dcol = {0, 0, -1, 1};
        
        while(!q.isEmpty()){
            Pair it = q.poll();
            int row = it.row;
            int col = it.col;
            int dist = it.dist;
            
            if(row == destrow && col == destcol) return dist;
            
            for(int i = 0; i < 4; i++){
                int nrow = row + drow[i];
                int ncol = col + dcol[i];
                
                if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                    vis[nrow][ncol] = 1;
                    q.add(new Pair(nrow, ncol, dist + 1));
                }
                
            }
        }
        return -1;
        
        
    }
}


