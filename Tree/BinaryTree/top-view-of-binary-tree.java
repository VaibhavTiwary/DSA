// You are given a binary tree, and your task is to return its top view. The top view of a binary tree
//  is the set of nodes visible when the tree is viewed from the top.

// Note: 
// Return the nodes from the leftmost node to the rightmost node.
// If two nodes are at the same position (horizontal distance) and are outside the shadow of the tree,
//  consider the leftmost node only. 
// Examples:
// Input: root[] = [1, 2, 3]
// Output: [2, 1, 3]



class Solution {
    static class Pair{
        int col;
        Node node;
        
        Pair(int col, Node node){
            this.col = col;
            this.node = node;
        }
    }
    static ArrayList<Integer> topView(Node root) {
        ArrayList <Integer> res = new ArrayList<>();
        
        if(root == null) return res;
        
        Map <Integer, Integer> map = new TreeMap<>();
        
        Queue <Pair> q = new LinkedList<>();
        q.add(new Pair(0, root));
        
        while(!q.isEmpty()){
            int coll = q.peek().col;
            Node temp = q.peek().node;
            q.remove();
            
            if(map.get(coll) == null) map.put(coll, temp.data);
            if(temp.left != null) q.add(new Pair(coll-1, temp.left));
            if(temp.right != null) q.add(new Pair(coll+1, temp.right));
        }
        for(Map.entry<Integer, Integer> entry : map.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }
}
