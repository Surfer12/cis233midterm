package bt;
// Assuming root is the root of a binary search tree, what is the time complexity of the printElements method?  


class Node {
    int data;
    Node left;
    Node right;
}

public class PrintElements {
    public void printElements(Node root) { 
        if (root == null) {
            return;
        }
        printElements(root.left);
        System.out.println(root.data);
        printElements(root.right); 
    }
}