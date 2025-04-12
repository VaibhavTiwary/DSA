// There are n cities. Some of them are connected, while some are not. If city a is connected directly 
// with city b, and city b is connected directly with city c, then city a is connected indirectly with 
// city c.

// A province is a group of directly or indirectly connected cities and no other cities outside of the
//  group.

// You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city 
// are directly connected, and isConnected[i][j] = 0 otherwise.

// Return the total number of provinces.

 

// Example 1:


// Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
// Output: 2

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        int count = 0;
        for(int i = 0; i < n; i++){
            if(vis[i] == false){
                dfs(isConnected,i,vis);
                count += 1;
            }
        }

        return count;
    }

    public void dfs(int[][] isConnected,int node,boolean[] vis){
        vis[node] = true;

        for(int i = 0; i < isConnected.length; i++){
            if(isConnected[node][i] == 1 && !vis[i]){
                dfs(isConnected,i,vis);
            }
        }
    }


}
