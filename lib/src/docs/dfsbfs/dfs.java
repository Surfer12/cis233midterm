import java.util.HashSet;
import java.util.Set;
import lib.src.main.java.cis233midterm.Node;



public class dfs {
    Node root;

    void dfs(Node root) {
        if (root == null) return;
        
    Set<Node> visited = new HashSet<>();
    dfsRecursive(root, visited);
}

void dfsRecursive(Node node, Set<Node> visited) {
    visited.add(node);
    System.out.print(node.val + " ");
    
    for (Node neighbor : node.neighbors) {
        if (!visited.contains(neighbor)) {
            dfsRecursive(neighbor, visited);
        }
    }
}

