package generic;
import java.util.function.Consumer;

public class InOrderTraversal<T> {
    public class TreeNode {
        T data;
        TreeNode left;
        TreeNode right;
        TreeNode(T item) {
            data = item; 
            left = right = null;
        }
    }

    public void inOrderTraversal(TreeNode root, Consumer<T> action) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left, action);
        action.accept(root.data);
        inOrderTraversal(root.right, action);
    }

    public void preOrderTraversal(TreeNode root, Consumer<T> action) {
        if (root == null) {
            return;
        }
        action.accept(root.data);
        preOrderTraversal(root.left, action);
        preOrderTraversal(root.right, action);
    }

    public void postOrderTraversal(TreeNode root, Consumer<T> action) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left, action);
        postOrderTraversal(root.right, action);
        action.accept(root.data);
    }
}
