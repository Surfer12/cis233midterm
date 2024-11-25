package cis233midterm;

public class TreeTraversal {
    public void printElements(Node root) {
        if (root == null) {
            return;
        }
        for (int data : GenericTraversal.inOrderTraversal(root)) {
            System.out.println(data);
        }
    }
}
