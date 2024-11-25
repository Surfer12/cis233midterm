// Write a Java method to perform an in-order traversal of a binary tree. You can assume a Node class with left and right child pointers and an int data field.
public class InOrderTraversal {
    class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int item) {
            data = item; 
            left = right = null;
        }
    }

    public void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.println(root.data);
        inOrderTraversal(root.right);
    }
    public void preOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    public void postOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.data);
    }
}
