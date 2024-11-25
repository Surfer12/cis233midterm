package cis233midterm;

public class BinarySearchTree<T extends Comparable<T>> {
    TreeNode<T> root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(T value) {
        root = insertRec(root, value);
    }

    private TreeNode<T> insertRec(TreeNode<T> root, T value) {
        if (root == null) {
            return new TreeNode<>(value);
        }

        if (value.compareTo(root.val) < 0) {
            root.left = insertRec(root.left, value);
        } else if (value.compareTo(root.val) > 0) {
            root.right = insertRec(root.right, value);
        }

        return root;
    }
}
