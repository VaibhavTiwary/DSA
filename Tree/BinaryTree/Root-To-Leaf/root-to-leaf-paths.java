// Given a Binary Tree, you need to find all the possible paths from the root node to all the leaf nodes
//  of the binary tree.

// Note: The paths should be returned such that paths from the left subtree of any node are listed first,
//  followed by paths from the right subtree.

// Examples:

// Input: root[] = [1, 2, 3, 4, 5]
// ex-3
// Output: [[1, 2, 4], [1, 2, 5], [1, 3]] 
// Explanation: All possible paths: 1->2->4, 1->2->5 and 1->3


class Solution {
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList <Integer> list = new ArrayList<>();
        
        // if(root == null) return ans;
        
        backtrack(root, ans, list);
        return ans;
    }
    
    static void backtrack(Node root, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> list){
        if(root == null){
            return;
        }
        
        list.add(root.data);
        
        if(root.left == null && root.right == null){
            ans.add(new ArrayList<>(list));
        }
        
        else {
            backtrack(root.left, ans, list);
            backtrack(root.right, ans, list);
        }
        list.remove(list.size() - 1);
    }

    
    
}

