// There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1. 
// You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to.
//  More formally, for each v in graph[u], there is an undirected edge between node u and node v. 
//  The graph has the following properties:

// There are no self-edges (graph[u] does not contain u).
// There are no parallel edges (graph[u] does not contain duplicate values).
// If v is in graph[u], then u is in graph[v] (the graph is undirected).
// The graph may not be connected, meaning there may be two nodes u and v such that there is no path 
// between them.
// A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that
//  every edge in the graph connects a node in set A and a node in set B.

// Return true if and only if it is bipartite.

 

// Example 1:


// Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
// Output: false
// Explanation: There is no way to partition the nodes into two independent sets such that every 
// edge connects a node in one and a node in the other.


// You’re trying to color the graph using 2 colors (say Red and Blue), where no two connected nodes 
// have the same color.

// If this is possible → the graph is bipartite.

class Solution {
    class Pair{
        int first;
        int second;

        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] color = new int[V];
        Arrays.fill(color, -1);

        Queue <Pair> queue = new LinkedList<>();

        for(int i = 0; i < V; i++){
            if(color[i] == -1){
                queue.add(new Pair(i, 0));
                color[i] = 0;

                while(!queue.isEmpty()){
                    int node = queue.peek().first;
                    int colour = queue.peek().second;
                    queue.remove();

                    for(int neighbour : graph[node]){
                        if(color[neighbour] == -1){
                            color[neighbour] = 1 - colour;
                            queue.add(new Pair(neighbour, color[neighbour]));
                        }
                        else if(color[neighbour] == colour) return false;
                    }
                }
            }
        }    
        
        return true;
    }
}