// You are given two trees:

// Tree 1 with nodes labeled from 0 to n-1

// Tree 2 with nodes labeled from 0 to m-1

// You are also given an integer k.

// For each node in Tree 1, you are allowed to temporarily connect it to any node in Tree 2 
// (like a bridge). Once connected, we say a node v is target to u if it is reachable from u in 
// at most k steps (edges).

//  You need to calculate for each node i in Tree 1, what is the maximum number of nodes that
//  can be reached (including nodes from both Tree 1 and Tree 2) if you connect it to the best
//   possible node in Tree 2.


//Find for each node how many nodes are at a dostance of k or less than k for tree 1
// and <= k-1 for tree 2 because we can connec tree1 and tree2 so so distance will already be 1 
// for connecting so we only need to calculate for k-1

//For each node in Tree 2, run DFS to count how many nodes are reachable in ≤k-1 steps. 
// Track the maximum such value.
//add this maximum for each node of tree1

class Solution {
    ArrayList<ArrayList<Integer>> adj2 = new ArrayList<>(); // For Tree2

    // DFS function to count nodes at distance <= k
    private int dfs(int node, int depth, int k, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        if (depth > k) return 0;
        visited[node] = true;
        int count = 1; // count self

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                count += dfs(neighbor, depth + 1, k, visited, adj);
            }
        }
        return count;
    }

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;

        // Build adj list for Tree2
        for (int i = 0; i < m; i++) {
            adj2.add(new ArrayList<>());
        }
        for (int[] edge : edges2) {
            int u = edge[0];
            int v = edge[1];
            adj2.get(u).add(v);
            adj2.get(v).add(u);
        }

        // Step 1: Find max reachable nodes in Tree2 within k steps
        int maxTree2Reach = 0;
        for (int i = 0; i < m; i++) {
            boolean[] visited = new boolean[m];
            int count = dfs(i, 0, k-1, visited, adj2);
            maxTree2Reach = Math.max(maxTree2Reach, count);
        }

        // Step 2: Build Tree1 and compute for each node
        ArrayList<ArrayList<Integer>> adj1 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj1.add(new ArrayList<>());
        }
        for (int[] edge : edges1) {
            int u = edge[0];
            int v = edge[1];
            adj1.get(u).add(v);
            adj1.get(v).add(u);
        }

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            int count = dfs(i, 0, k, visited, adj1);
            answer[i] = count + maxTree2Reach;
        }

        return answer;
    }
}
