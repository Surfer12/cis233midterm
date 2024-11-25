import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


public class bfs<T> {
    Node<T> root;

    void bfs(Node<T> root) {
        if (root == null) return;
        
        Queue<Node<T>> queue = new LinkedList<>();
        Set<Node<T>> visited = new HashSet<>();
    
        queue.offer(root);
        visited.add(root);
    
        while (!queue.isEmpty()) {
            Node<T> current = queue.poll();
            System.out.print(current.val + " ");
        
            for (Node<T> neighbor : current.neighbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
    }

    static class Node<T> {
        T val;
        Set<Node<T>> neighbors;

        Node(T val) {
            this.val = val;
            this.neighbors = new HashSet<>();
        }
    }
}
