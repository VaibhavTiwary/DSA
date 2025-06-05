//GFG

// Given a Directed Acyclic Graph (DAG) with V nodes labeled from 0 to V-1, and a list of directed edges, 
// count the total number of distinct paths from a given start node to a destination node. 
// Each edge is represented as edges[i] = [u, v], indicating a directed edge from u to v.

// Examples :

// Input: edges[][] = [[0,1], [0,3], [2,0], [2,1], [1,3]], V = 4, src = 2, dest = 3
// Output: 3
// Explanation: There are three ways to reach at 3 from 2. These are: 2 -> 1 -> 3, 2 -> 0 -> 3 and 
// 2 -> 0 -> 1 -> 3.

//We can also solve it using bfs with slight variation but that would cause TLE because we would 
// not have to track visited that would cause unnecessary traversals which would cause 
//Exponential TC

//We will use DFS with memoization
// TC and SC- O(V + E)

class Solution {
    public int countPaths(int[][] edges, int V, int src, int dest) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            
        }
        
        int[] dp = new int[V];
        Arrays.fill(dp, -1);
        
        return dfs(adj, src, dest, dp);
    }
    
    int dfs(ArrayList<ArrayList<Integer>> adj, int node, int dest, int[] dp){
        if(node == dest) return 1;
        if(dp[node] != -1) return dp[node];
        
        int paths = 0;
        for(int neighbours : adj.get(node)){
            paths += dfs(adj, neighbours, dest, dp);
        }
        
        dp[node] = paths;
        return paths;
    }
}