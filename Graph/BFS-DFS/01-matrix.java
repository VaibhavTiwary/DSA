// Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

// The distance between two cells sharing a common edge is 1.

 

// Example 1:


// Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
// Output: [[0,0,0],[0,1,0],[0,0,0]]

//O(m * n)

class Solution {
    class Pair {
        int first;
        int second;
        int third;

        Pair(int first, int second, int third){
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] res = new int[m][n];
        int[][] vis = new int[m][n];

        Queue <Pair> queue = new LinkedList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    queue.add(new Pair(i,j,0));
                    vis[i][j] = 0;
                }
                else {
                    vis[i][j] = 1;
                }
            }
        }

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        while(!queue.isEmpty()){
            int row = queue.peek().first;
            int col = queue.peek().second;
            int steps = queue.peek().third;
            queue.remove();
            res[row][col] = steps;

            for(int i = 0; i < 4; i++){
                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && vis[nrow][ncol] == 1){
                    vis[nrow][ncol] = 0;
                    queue.add(new Pair(nrow, ncol, steps + 1));
                }
            }
        }
        return res;
    }

    
}