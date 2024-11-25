package cis233midterm;

public class TreeTraversal {
    public void printElements(Node root) {
        if (root == null) {
            return;
        }
        printElements(root.left);
        System.out.println(root.data);
        printElements(root.right); 
    }
}
