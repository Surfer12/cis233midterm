import java.util.HashSet;
import java.util.Set;
import generic.graphs.Graph;

/**
 * This class contains a method to perform Depth-First Search (DFS) on a graph.
 */
public class dfs {
    Node root;

    /**
     * Performs Depth-First Search (DFS) on a graph starting from the given root node.
     * 
     * @param root The root node of the graph.
     * 
     * Time Complexity: O(V + E), where V is the number of vertices and E is the number of edges in the graph.
     */
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
}
