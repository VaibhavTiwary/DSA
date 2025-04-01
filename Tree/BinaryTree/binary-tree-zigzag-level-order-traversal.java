// Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. 
// (i.e., from left to right, then right to left for the next level and alternate between).

 

// Example 1:


// Input: root = [3,9,20,null,null,15,7]
// Output: [[3],[20,9],[15,7]]

// TC and SC- O(N);

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue <TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            List<Integer> nodes = new ArrayList<>();
            int levelSize = q.size();

            for(int i = 0 ; i < levelSize; i++){
                TreeNode currNode = q.poll();
                nodes.add(currNode.val);

                if(currNode.left != null){
                    q.add(currNode.left);
                }
                if(currNode.right != null){
                    q.add(currNode.right);
                }
            }
            if(ans.size() % 2 == 1){
                Collections.reverse(nodes);
            }
            ans.add(nodes);
        }
        return ans;
    }
    
}