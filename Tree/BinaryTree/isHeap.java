boolean preOrder(Node tree){
        if(tree == null) return true;
        
        if(tree.left != null && tree.left.data > tree.data) return false;
        if(tree.right != null && tree.right.data > tree.data) return false;

        return preOrder(tree.left) && preOrder(tree.right);
}