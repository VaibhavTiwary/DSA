// You are given an image represented by an m x n grid of integers image, where image[i][j] represents 
// the pixel value of the image. You are also given three integers sr, sc, and color. Your task is to 
// perform a flood fill on the image starting from the pixel image[sr][sc].

// To perform a flood fill:

// Begin with the starting pixel and change its color to color.
// Perform the same process for each pixel that is directly adjacent (pixels that share a side with the 
// original pixel, either horizontally or vertically) and shares the same color as the starting pixel.
// Keep repeating this process by checking neighboring pixels of the updated pixels and modifying their
//  color if it matches the original color of the starting pixel.
// The process stops when there are no more adjacent pixels of the original color to update.
// Return the modified image after performing the flood fill.

 

// Example 1:

// Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2

// Output: [[2,2,2],[2,2,0],[2,0,1]]

//O(m*n) TC and SCs

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        
        int iniColor = image[sr][sc];
        int[][] res = image;

        int[] delrow = {-1, 0, +1, 0};
        int[] delcol = {0, +1, 0, -1};

        dfs(sr, sc, iniColor, res, delrow, delcol, image, color);
        return res;
    }

    private void dfs(int row, int col, int iniColor, int[][] res, int[] delrow, int[] delcol, int[][] image, int color){

        int m = image.length;
        int n = image[0].length;

        res[row][col] = color;

        for(int i = 0; i < 4; i++){
            int newrow = row + delrow[i];
            int newcol = col + delcol[i];
            if(newrow >= 0 && newrow < m && newcol >= 0 && newcol < n && image[newrow][newcol] == iniColor && res[newrow][newcol] != color){
                dfs(newrow, newcol, iniColor, res, delrow, delcol, image, color);
            }
        }
        
    }
    
}