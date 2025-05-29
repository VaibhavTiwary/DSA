// L-112

// Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to
// leaf path such that adding up all the values along the path equals targetSum.

// A leaf is a node with no children.


// TC- O(N)
// SC- O(N) in worst case(Skewed) ans O(log n) for balanced tree
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null)return false;

        if(root.left == null && root.right == null){
            if(targetSum == root.val) return true;
            return false;
        }

        return hasPathSum(root.left, targetSum - root.val) ||
               hasPathSum(root.right, targetSum - root.val);
    }
}