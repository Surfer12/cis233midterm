package generic;

import java.util.*;

// Separate GenericNode class
class GenericNode<T> {
    T data;
    GenericNode<T> left;
    GenericNode<T> right;
    Set<GenericNode<T>> neighbors;

    public GenericNode(T data) {
        this.data = data;
        this.neighbors = new HashSet<>();
    }

    public void addNeighbor(GenericNode<T> neighbor) {
        neighbors.add(neighbor);
    }
}

public class GenericTraversal<T> {
   
    // Method to perform Breadth-First Search (BFS) traversal using the Node class
    public List<T> bfs(GenericNode<T> startNode) {
        List<T> visitedNodes = new ArrayList<>();
        Queue<GenericNode<T>> queue = new LinkedList<>();
        Set<GenericNode<T>> visited = new HashSet<>();

        queue.offer(startNode);
        visited.add(startNode);

        while (!queue.isEmpty()) {
            GenericNode<T> currentNode = queue.poll();
            visitedNodes.add(currentNode.data);

            for (GenericNode<T> neighbor : currentNode.neighbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }

        return visitedNodes;
    }

    // Method to perform Depth-First Search (DFS) traversal using the Node class
    public List<T> dfs(GenericNode<T> startNode) {
        List<T> visitedNodes = new ArrayList<>();
        Set<GenericNode<T>> visited = new HashSet<>();
        dfsRecursive(startNode, visited, visitedNodes);
        return visitedNodes;
    }

    private void dfsRecursive(GenericNode<T> node, Set<GenericNode<T>> visited, List<T> visitedNodes) {
        visited.add(node);
        visitedNodes.add(node.data);

        for (GenericNode<T> neighbor : node.neighbors) {
            if (!visited.contains(neighbor)) {
                dfsRecursive(neighbor, visited, visitedNodes);
            }
        }
    }

    // Method to perform in-order traversal using the Node class 
    public List<T> inOrderTraversal(GenericNode<T> root) {
        List<T> result = new ArrayList<>();
        inOrderTraversalHelper(root, result);
        return result;
    }

    private void inOrderTraversalHelper(GenericNode<T> node, List<T> result) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            inOrderTraversalHelper(node.left, result);
        }
        result.add(node.data);
        if (node.right != null) {
            inOrderTraversalHelper(node.right, result);
        }
    }

    public List<T> preOrderTraversal(GenericNode<T> root) {
        List<T> result = new ArrayList<>();
        preOrderTraversalHelper(root, result);
        return result;
    }

    private void preOrderTraversalHelper(GenericNode<T> node, List<T> result) {
        if (node == null) {
            return;
        }
        result.add(node.data);
        if (node.left != null) {
            preOrderTraversalHelper(node.left, result);
        }
        if (node.right != null) {
            preOrderTraversalHelper(node.right, result);
        }
    }

    public List<T> postOrderTraversal(GenericNode<T> root) {
        List<T> result = new ArrayList<>();
        postOrderTraversalHelper(root, result);
        return result;
    }

    private void postOrderTraversalHelper(GenericNode<T> node, List<T> result) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            postOrderTraversalHelper(node.left, result);
        }
        if (node.right != null) {
            postOrderTraversalHelper(node.right, result);
        }
        result.add(node.data);
    }

    public static void main(String[] args) {
        // Example usage of tree traversals
        GenericNode<Integer> root = new GenericNode<>(1);
        root.left = new GenericNode<>(2);
        root.right = new GenericNode<>(3);
        root.left.left = new GenericNode<>(4);
        root.left.right = new GenericNode<>(5);

        GenericTraversal<Integer> traversal = new GenericTraversal<>();
        
        System.out.println("In-order traversal: " + traversal.inOrderTraversal(root));
        System.out.println("Pre-order traversal: " + traversal.preOrderTraversal(root));
        System.out.println("Post-order traversal: " + traversal.postOrderTraversal(root));
    }
}
