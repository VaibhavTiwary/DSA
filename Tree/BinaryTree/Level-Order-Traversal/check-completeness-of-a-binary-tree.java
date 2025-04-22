// Given the root of a binary tree, determine if it is a complete binary tree.

// In a complete binary tree, every level, except possibly the last, is completely filled, and all 
// nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive 
// at the last level h.

// Input: root = [1,2,3,4,5,6]
// Output: true
// Explanation: Every level before the last is full (ie. levels with node-values {1} and {2, 3}), and 
// all nodes in the last level ({4, 5, 6}) are as far left as possible.
// Example 2:


// Input: root = [1,2,3,4,5,null,7]
// Output: false
// Explanation: The node with value 7 isn't as far left as possible.

//...............................CORE LOGIC....................................

// Once you encounter a null child during level-order (BFS) traversal, 
// all following nodes must also be null i.e we must not get any child further

// If any non-null node comes after a null, the tree is not complete.




class Solution {
    public boolean isCompleteTree(TreeNode root) {
        
        Queue <TreeNode> q = new LinkedList<>();
        q.add(root);

        boolean flag = false;

        while(!q.isEmpty()){
            int size = q.size();
        
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();

                if(node.left != null){
                    if(flag) return false;
                    q.add(node.left);
                }
                else flag = true;
                    
                if(node.right != null){
                    if(flag) return false;
                    q.add(node.right);
                }
                else flag = true;
            }
        }
        return true;

    }
}
