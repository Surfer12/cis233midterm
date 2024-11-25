package cis233midterm;

import lib.src.docs.legacyalgo.Node;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.function.Consumer;

public class BinarySearchTree<T> {
    Node<T> root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(T value) {
        root = insertRec(root, value);
    }

    private Node<T> insertRec(Node<T> root, T value) {
        if (root == null) {
            return new Node<>(value);
        }
        // Assuming T implements Comparable for comparison
        if (((Comparable<T>) value).compareTo(root.data) < 0) {
            root.left = insertRec(root.left, value);
        } else if (((Comparable<T>) value).compareTo(root.data) > 0) {
            root.right = insertRec(root.right, value);
        }
        return root;
    }

    public void inOrderTraversal(Consumer<T> action) {
        InOrderTraversal<T> traversal = new InOrderTraversal<>();
        traversal.inOrderTraversal(root, action);
    }

    public void preOrderTraversal(Consumer<T> action) {
        InOrderTraversal<T> traversal = new InOrderTraversal<>();
        traversal.preOrderTraversal(root, action);
    }

    public void postOrderTraversal(Consumer<T> action) {
        InOrderTraversal<T> traversal = new InOrderTraversal<>();
        traversal.postOrderTraversal(root, action);
    }

    public void dfsTraversal() {
        GenericDFS<Node<T>> dfs = new GenericDFS<>();
        Set<Node<T>> visited = new HashSet<>();
        dfs.dfs(root, visited, new Graph<Node<T>>() {
            @Override
            public Set<Node<T>> getNeighbors(Node<T> node) {
                Set<Node<T>> neighbors = new HashSet<>();
                if (node.left != null) neighbors.add(node.left);
                if (node.right != null) neighbors.add(node.right);
                return neighbors;
            }
        });
    }

    public void bfsTraversal() {
        GenericBFS<Node<T>> bfs = new GenericBFS<>();
        Queue<Node<T>> queue = new LinkedList<>();
        Set<Node<T>> visited = new HashSet<>();
        bfs.bfs(root, queue, visited, new Graph<Node<T>>() {
            @Override
            public Set<Node<T>> getNeighbors(Node<T> node) {
                Set<Node<T>> neighbors = new HashSet<>();
                if (node.left != null) neighbors.add(node.left);
                if (node.right != null) neighbors.add(node.right);
                return neighbors;
            }
        });
    }
}
