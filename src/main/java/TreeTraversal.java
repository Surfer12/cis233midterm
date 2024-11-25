import generic.GenericTraversal.GenericNode;

public class TreeTraversal {
    public void printElements(GenericNode root) {
        if (root == null) {
            return;
        }
        printElements(root.getLeft()); // Use getter method instead of direct access
        System.out.println(root.data);
        printElements(root.getRight()); // Use getter method instead of direct access
    }
}
