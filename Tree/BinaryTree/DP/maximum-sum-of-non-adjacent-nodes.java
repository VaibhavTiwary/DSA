// Given a binary tree with a value associated with each node. Your task is to select a subset of nodes 
// such that the sum of their values is maximized, with the condition that no two selected nodes are 
// directly connected that is, if a node is included in the subset, neither its parent nor its children 
// can be included.
// Input: root[] = [1, 2, 3, 4, N, 5, 6]

// Output: 16
// Explanation: The maximum sum is obtained by selecting the nodes 1, 4, 5, and 6, 
// which are not directly connected to each other. Their total sum is 16.  





class Solution {
    // Function to return the maximum sum of non-adjacent nodes.
    HashMap <Node, Integer> dp = new HashMap<>();
    
    public int getMaxSum(Node root) {
        
        
        if(root == null) return 0;
        
        if(dp.containsKey(root)) return dp.get(root);
        
        int include = root.data;
        if(root.left != null){
            include += getMaxSum(root.left.left) + getMaxSum(root.left.right);
        }
        
        if(root.right != null){
            include += getMaxSum(root.right.left) + getMaxSum(root.right.right);
        }
        
        int exclude = getMaxSum(root.left) + getMaxSum(root.right);
        int result = Math.max(include, exclude);
        dp.put(root, result);
        return result;
    }
}