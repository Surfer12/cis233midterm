package dfsbfs;

import java.util.HashSet;
import java.util.Set;

public class dfs<T> {
    Node<T> root;

    void dfs(Node<T> root) {
        if (root == null) return;
        
        Set<Node<T>> visited = new HashSet<>();
        dfsRecursive(root, visited);
    }

    void dfsRecursive(Node<T> node, Set<Node<T>> visited) {
        visited.add(node);
        System.out.print(node.val + " ");
        
        for (Node<T> neighbor : node.neighbors) {
            if (!visited.contains(neighbor)) {
                dfsRecursive(neighbor, visited);
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
