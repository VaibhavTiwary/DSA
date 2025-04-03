// Given a binary tree having n nodes. Check whether all of its nodes have a value equal to the sum of 
// their child nodes. Return 1 if all the nodes in the tree satisfy the given properties,
//  else it returns 0. For every node, the data value must be equal to the sum of the data values
//   in the left and right children. Consider the data value 0 for a NULL child. Also, leaves are 
//   considered to follow the property.

// Examples:

// Input:
// Binary tree
//        35
//       /  \
//      20   15
//     / \   / \
//    15  5 10  5

// Output: 1
// Explanation: 
// Here, every node is sum of its left and right child.




//User function Template for Java


/*Complete the function below
Node is as follows:
class Node{
	int data;
	Node left,right;
	
	Node(int key)
	{
	    data = key;
	    left = right = null;
	}
}

*/
class Solution
{
    static class Pair{
        Node root;
        int curSum;
        Pair(Node root, int curSum){
            this.root = root;
            this.curSum = curSum;
        }
    }
    
    public static int isSumProperty(Node root)
    {
        Queue <Pair> q = new LinkedList<>();
        q.add(new Pair(root, root.data));
        
        while(!q.isEmpty()){
            Pair it = q.remove();
            
            Node curNode = it.root;
            int temp = it.curSum;
            
            int childSum = 0;
            if (curNode.left != null) {
                childSum += curNode.left.data;
                q.add(new Pair(curNode.left, curNode.left.data));
            }

            if (curNode.right != null) {
                childSum += curNode.right.data;
                q.add(new Pair(curNode.right, curNode.right.data));
            }
            
            if ((curNode.left != null || curNode.right != null) && curNode.data != childSum) {
                return 0;
            }
        }
        return 1;
    }
            
}









