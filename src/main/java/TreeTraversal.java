import generic.GenericNode;

public class TreeTraversal {
    public <T> void printElements(GenericNode<T> root) {
        if (root != null) {
            printElements(root.getLeft());
            System.out.println(root.getData());
            printElements(root.getRight());
        }
    }
}
