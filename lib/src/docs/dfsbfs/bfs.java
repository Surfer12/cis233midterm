import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class bfs {
    Node root;

    void bfs(Node root) {
        if (root == null) return;
        
    Queue<Node> queue = new LinkedList<>();
    Set<Node> visited = new HashSet<>();
    
    queue.offer(root);
    visited.add(root);
    
    while (!queue.isEmpty()) {
        Node current = queue.poll();
        System.out.print(current.val + " ");
        
        for (Node neighbor : current.neighbors) {
            if (!visited.contains(neighbor)) {
                visited.add(neighbor);
                queue.offer(neighbor);
            }
            }
        }
    }
}