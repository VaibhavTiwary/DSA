// Given a binary tree, return an array where elements represent the bottom view of the binary tree from 
// left to right.

// Note: If there are multiple bottom-most nodes for a horizontal distance from the root, then the latter
//  one in the level traversal is considered. For example, in the below diagram, 3 and 4 are both the
//   bottommost nodes at a horizontal distance of 0, here 4 will be considered.

//                       20
//                     /    \
//                   8       22
//                 /   \     /   \
//               5      3 4     25
//                      /    \      
//                  10       14

// For the above tree, the output should be 5 10 4 14 25.

// Examples :

// Input:
//        1
//      /   \
//     3     2
// Output: 3 1 2
// Explanation: First case represents a tree with 3 nodes and 2 edges where root is 1, 
// left child of 1 is 3 and right child of 1 is 2.


class Solution
{
    
    class Pair{
        int col;
        Node node;
        
        Pair(int col, Node node){
            this.col = col;
            this.node = node;
        }
    }
    
    public ArrayList <Integer> bottomView(Node root)
    {
        ArrayList <Integer> res = new ArrayList<>();
        if(root == null) return res;
        
        Map <Integer, Integer> map = new TreeMap<>();
        
        Queue <Pair> q = new LinkedList<>();
        q.add(new Pair(0, root));
        
        while(!q.isEmpty()){
            int coll = q.peek().col;
            Node temp = q.peek().node;
            q.remove();
            
            map.put(coll, temp.data);
            if(temp.left != null){
                q.add(new Pair(coll - 1, temp.left));
            }
            
            if(temp.right != null){
                q.add(new Pair(coll + 1, temp.right));
            }
            
            
        }
        
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }
}