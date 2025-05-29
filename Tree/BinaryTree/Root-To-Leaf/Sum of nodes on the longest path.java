//GFG POTD 29th may 2025

// Given a binary tree root[], you need to find the sum of the nodes on the longest path from the root
//  to any leaf node. If two or more paths have the same length, the path with the maximum sum of node
//   values should be considered.

// Examples:

// Input: root[] = [4, 2, 5, 7, 1, 2, 3, N, N, 6, N]
 
// Output: 13

class Solution {
    int maxDepth = 0;
    int maxSum = 0;
    
    public int sumOfLongRootToLeafPath(Node root) {
        dfs(root, 0, 0);
        return maxSum;
        
    }
    void dfs(Node root, int depth, int curSum){
        
        if(root == null){
            return;
        }   
        curSum += root.data;
        depth++;
        
        
        if(root.left == null && root.right == null){
            if(depth > maxDepth){
                maxDepth = depth;
                maxSum = curSum;
            } 
            else if(depth == maxDepth){
                maxSum = Math.max(curSum, maxSum);
            }
            return;
        }
        
        dfs(root.left, depth, curSum);
        dfs(root.right, depth, curSum);
        
    }
}