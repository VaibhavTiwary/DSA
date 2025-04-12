You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are 
surrounded:

// Connect: A cell is connected to adjacent cells horizontally or vertically.
// Region: To form a region connect every 'O' cell.
// Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and 
// none of the region cells are on the edge of the board.
// To capture a surrounded region, replace all 'O's with 'X's in-place within the original board.
//  You do not need to return anything.

 

// Example 1:

// Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]

// Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]

// Explanation:


// In the above diagram, the bottom region is not captured because it is on the edge of the board and
//  cannot be surrounded.

//If at any boundary we get O then all connected O's from that one will never be surrounded by X.
// // So we are checking on boundaries and caling dfs if we get O
// in dfs we are checking all 4 directions and connected O if found just mark them in visited.
// At last if we still have O in main grid and that is still not visited then it means those O are 
// not conncted tp any boundary O
//We can replace them with X

TC and Sc- O(M*N)

class Solution {
    public void solve(char[][] board) {
        
        int m = board.length;
        int n = board[0].length;

        int[][] vis = new int[m][n];
        for(int[] row : vis){
            Arrays.fill(row, 0);
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0 || i == m-1 || j == n-1){
                    if(board[i][j] == 'O' && vis[i][j] == 0){
                        dfs(i, j, board, vis);
                    }
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O' && vis[i][j] == 0){
                    board[i][j] = 'X';
                }
            }
        }
    }

    void dfs(int row, int col, char[][] board, int[][] vis){
        vis[row][col] = 1;
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < 4; i++){
            int nrow = row + drow[i];
            int ncol = col + dcol[i];
            
            if(nrow >= 0 && ncol >= 0 && nrow < m && ncol < n && board[nrow][ncol] == 'O' && vis[nrow][ncol] == 0){
                dfs(nrow, ncol, board, vis);
            }
        }
    }
}