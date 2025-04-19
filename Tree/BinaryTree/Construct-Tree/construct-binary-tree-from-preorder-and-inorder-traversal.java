// Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree
//  and inorder is the inorder traversal of the same tree, construct and return the binary tree.

// Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
// Output: [3,9,20,null,null,15,7]


class Solution {
    private int preorderIndex = 0; // Tracks the current root in the preorder array
    private HashMap<Integer, Integer> inorderIndexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Populate the hashmap with indices from the inorder array
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return constructTree(preorder, 0, inorder.length - 1);
    }

    private TreeNode constructTree(int[] preorder, int left, int right) {
        if (left > right) {
            return null; // No subtree to construct
        }

        // Get the current root value from preorder and increment the index
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        // Get the index of the root in the inorder array
        int rootIndex = inorderIndexMap.get(rootValue);

        // Build the left and right subtrees
        root.left = constructTree(preorder, left, rootIndex - 1);
        root.right = constructTree(preorder, rootIndex + 1, right);

        return root;
    }
}

// TC-(O(n)): Each node is visited once, and the hashmap provides O(1) access to indices.
//SC- (O(n)): For the hashmap and recursion stack in the worst case.