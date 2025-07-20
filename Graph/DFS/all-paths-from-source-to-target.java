// Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and
//  return them in any order.

// The graph is given as follows: graph[i] is a list of all nodes you can visit from node i 
// (i.e., there is a directed edge from node i to node graph[i][j]).

 

// Example 1:


// Input: graph = [[1,2],[3],[3],[]]
// Output: [[0,1,3],[0,2,3]]
// Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
// Example 2:


// Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
// Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]


// ......TC

// In the worst case:
// Each node has multiple outgoing edges.
// Every path is explored independently.
// The number of total paths can grow exponentially.

// n = number of nodes
// P = number of distinct paths from node 0 to node n-1
// L = average length of each path

// Then:
// ✅ Total Time = O(P × L)

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> paths = new ArrayList<>();

        paths.add(0);

        dfs(ans, paths, graph, 0);
        return ans;
    }

    void dfs(List<List<Integer>> ans, List<Integer> paths, int[][] graph, int start){

        if (start == graph.length - 1) {
            ans.add(new ArrayList<>(paths));
            return;
        }

        for(int neighbours : graph[start]){
            paths.add(neighbours);
            dfs(ans, paths, graph, neighbours);
            paths.remove(paths.size() - 1);
        }
        
    }
}

// Example- Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]

// 1.Start at node = 0, initialize path = [0].
// 2.From graph[0] = [4, 3, 1], begin looping over neighbors.

// 3.First neighbor is 4.
// → Add it to the path: path = [0, 4].

// 4.Call dfs(4, path).
// 5.Inside dfs(4), check: node == graph.length - 1 (4 == 4) ✅
// → Base case hit: add [0, 4] to ans and return.

// 6.After return, control goes back to the point in dfs(0) where dfs(4) was called.
// 7.The next line executes: path.remove(path.size() - 1)
// → Backtrack to: path = [0]

// 8.Continue loop in dfs(0) with next neighbor: 3, then 1, and repeat the process recursively for all paths.



