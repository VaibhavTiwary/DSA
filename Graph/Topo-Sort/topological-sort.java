// Given a Directed Acyclic Graph (DAG) of V (0 to V-1) vertices and E edges represented as a 2D 
// list of edges[][], where each entry edges[i] = [u, v] denotes a directed edge u -> v. Return the
//  topological sort for the given graph.

// Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for 
// every directed edge u -> v, vertex u comes before v in the ordering.
// Note: As there are multiple Topological orders possible, you may return any of them. If your returned 
// Topological sort is correct then the output will be true else false.

// Examples:

// Input: V = 4, E = 3, edges[][] = [[3, 0], [1, 0], [2, 0]]

// Output: true
// Explanation: The output true denotes that the order is valid. Few valid Topological orders for 
// the given graph are:
// [3, 2, 1, 0]
// [1, 2, 3, 0]
// [2, 3, 1, 0]

//Kahn's algorithm / BFS
// TC and SC- O(V + E);

class Solution {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        
        int[] indegree = new int[V];
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v); 
        }
        
        
        for(int i = 0; i < V; i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }
        
        Queue <Integer> queue = new LinkedList<>();
        
        for(int i = 0; i < V; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        
        ArrayList <Integer> topo = new ArrayList<>();
        
        while(!queue.isEmpty()){
            int node = queue.peek();
            queue.remove();
            topo.add(node);
            
            for(int it : adj.get(node)){
                indegree[it]--;
                
                if(indegree[it] == 0){
                    queue.add(it);
                }
                
            }
        }
        return topo;    
    }
}