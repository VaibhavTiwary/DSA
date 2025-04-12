// There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. 
// You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must
//  take course bi first if you want to take course ai.

// For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
// Return true if you can finish all courses. Otherwise, return false.

 

// Example 1:

// Input: numCourses = 2, prerequisites = [[1,0]]
// Output: true
// Explanation: There are a total of 2 courses to take. 
// To take course 1 you should have finished course 0. So it is possible.
// Example 2:

// Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
// Output: false
// Explanation: There are a total of 2 courses to take. 
// To take course 1 you should have finished course 0, and to take course 0 you should also have finished 
// course 1. So it is impossible.

//Can be simply solved using topo sort and cycle detection 

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int[] indegree = new int[numCourses];

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : prerequisites){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }

        for(int i = 0; i < numCourses; i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }

        Queue <Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        ArrayList <Integer> topo = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            topo.add(node);

            for(int it : adj.get(node)){
                indegree[it]--;

                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }

        if(topo.size() == numCourses) return true;
        return false;




    }
}