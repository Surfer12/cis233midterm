import cis233midterm.Node;  

/**
 * This class contains a method to perform an in-order traversal of a binary search tree.
 */
public class printElements {

    /**
     * Performs an in-order traversal of a binary search tree and prints the elements.
     * 
     * @param root The root node of the binary search tree.
     * 
     * Time Complexity: O(n), where n is the number of nodes in the tree.
     * This is because the method visits each node exactly once.
     * 
     * Edge Cases:
     * - The tree is empty (i.e., the root is null).
     * - The tree has only one node (i.e., the root has no left or right children).
     * - The tree is left-skewed (i.e., every node has only a left child).
     * - The tree is right-skewed (i.e., every node has only a right child).
     * - The tree has duplicate values (i.e., multiple nodes with the same value).
     * - The tree is balanced (i.e., the left and right subtrees of every node differ in height by at most one).
     * - The tree is unbalanced (i.e., the left and right subtrees of some nodes differ significantly in height).
     */
    public void printElements(Node root) { 
        if (root == null) {
            return;
        }
        printElements(root.left);
        System.out.println(root.data);
        printElements(root.right); 
    }
}
