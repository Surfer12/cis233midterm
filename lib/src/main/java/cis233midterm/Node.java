public class Node {
    int data;
    Node left;
    Node right;
    List<Node> neighbors;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.neighbors = new ArrayList<>();
    }
}
