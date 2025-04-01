//TC and SC for both bfs and dfs is O(V+E) and O(V)
//BFS

class Pair {
    int node;
    int parent;

    Pair(int node, int parent) {
        this.node = node;
        this.parent = parent;
    }
}

class Solution {
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (bfs(i, adj, vis)) return true;
            }
        }
        return false;
    }

    private boolean bfs(int start, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(start, -1));
        vis[start] = true;

        while (!queue.isEmpty()) {
            int curNode = queue.peek().node;
            int curParent = queue.peek().parent;
            queue.remove();

            for (int neighbour : adj.get(curNode)) {
                if (!vis[neighbour]) {
                    vis[neighbour] = true;
                    queue.add(new Pair(neighbour, curNode));
                } 
                else if (curParent != neighbour) {
                    return true;
                }
            }
        }
        return false;
    }
}


//DFS
class Solution {
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (dfs(i,-1, adj, vis)) return true;
            }
        }
        return false;
    }

    private boolean dfs(int start, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        
        vis[start] = true;

        for (int neighbour : adj.get(start)) {
            if (!vis[neighbour]) {
                if(dfs(neighbour, start, adj, vis)) return true;
            } 
            else if (neighbour != parent) {
                return true;
            }
        }
        return false;
    }
}

