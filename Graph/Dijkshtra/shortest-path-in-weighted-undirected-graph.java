// You are given a weighted undirected graph having n vertices numbered from 1 to n and m edges along 
// with their weights. Find the shortest weight path between the vertex 1 and the vertex n,  if there 
// exists a path, and return a list of integers whose first element is the weight of the path, and the 
// rest consist of the nodes on that path. If no path exists, then return a list containing a single 
// element -1.

// The input list of edges is as follows - {a, b, w}, denoting there is an edge between a and b, and w is
//  the weight of that edge.

// Note: The driver code here will first check if the weight of the path returned is equal to the sum of 
// the weights along the nodes on that path, if equal it will output the weight of the path, else -2.
//  In case the list contains only a single element (-1) it will simply output -1. 

// Examples :

// Input: n = 5, m= 6, edges = [[1, 2, 2], [2, 5, 5], [2, 3, 4], [1, 4, 1], [4, 3, 3], [3, 5, 1]]
// Output: 5
// Explanation: Shortest path from 1 to n is by the path 1 4 3 5 whose weight is 5. 


//Same code as of dijkshtra but we are just having an extra parent array that is storing 
// the parent for each node because we need to print the path

class Solution {
    
    class Pair{                    //for minheap
        int distance;
        int node;
        
        Pair(int distance, int node){
            this.distance = distance;
            this.node = node;
        }
    }
    
    class Edge {                     //for adjacency list
        int node, weight;
        Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
    
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        
        PriorityQueue<Pair> minheap = new PriorityQueue<>((x, y) -> {
        if (x.distance == y.distance) {
            return x.node - y.node; 
        }
        return x.distance - y.distance; 
        });

        
        List<List<Edge>> adj = new ArrayList<>();
        
        for(int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            
            adj.get(u).add(new Edge(v, w));
            adj.get(v).add(new Edge(u, w));
        }
                                                
                                                
                                                
        int[] dis = new int[n + 1];
        for(int i = 0; i <= n; i++){
            dis[i] = Integer.MAX_VALUE;
        }
        
        int[] parent = new int[n + 1];
        for(int i = 0; i <= n; i++){
            parent[i] = -1;
        }
        
        dis[1] = 0;
        minheap.add(new Pair(0, 1));
        
        while(!minheap.isEmpty()){
            Pair it = minheap.poll();
            int dist = it.distance;
            int curnode = it.node;
            
            for(Edge e : adj.get(curnode)){
                int edgewt = e.weight;
                int adjnode = e.node;
                
                if(dist + edgewt < dis[adjnode]){
                    dis[adjnode] = dist + edgewt;
                    minheap.add(new Pair(dis[adjnode], adjnode));
                    parent[adjnode] = curnode;        //extra line for storing parent as we need to print the path
                }
            }
        }
        
        List <Integer> res = new ArrayList<>();
        
        if(dis[n] == Integer.MAX_VALUE){    //If we cannot reach the destination then our dis array will contain INTEGER.MAX_VALUE
            res.add(-1);
            return res;
        }
        
        //We are printing the path by getting indices from parent array until we reach source node i.e 1
        //  as the parent of 1 will be -1 so we will stop our loop at that point
        int temp = n;
        while(temp != -1){
            res.add(temp);
            temp = parent[temp];
        }
        
        res.add(dis[n]);
        Collections.reverse(res);
        return res;
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
}