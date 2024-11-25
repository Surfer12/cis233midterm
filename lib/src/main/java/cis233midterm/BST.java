import TreeNode;
public class BST {
    TreeNode root;
    //Add in order traversal method here
    public void inOrderTraversal(TreeNode root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.println(root.data);
            inOrderTraversal(root.right);
        }
    }
}