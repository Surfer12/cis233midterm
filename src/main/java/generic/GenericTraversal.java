package generic;
import java.util.*;
import generic.GenericNode;

public class GenericTraversal {
    public static class GenericNode<T> {
        T data;
        List<GenericNode<T>> neighbors;
    }       
    // Method to perform Breadth-First Search (BFS) traversal using the Node class
    public static List<Integer> bfs(GenericNode<T> startNode) {
        List<Integer> visitedNodes = new ArrayList<>();
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
    public static List<Integer> dfs(GenericNode<T> startNode) {
        List<Integer> visitedNodes = new ArrayList<>();
        Set<GenericNode<T>> visited = new HashSet<>();
        dfsRecursive(startNode, visited, visitedNodes);
        return visitedNodes;
    }

    private static void dfsRecursive(GenericNode<T> node, Set<GenericNode<T>> visited, List<Integer> visitedNodes) {
        visited.add(node);
        visitedNodes.add(node.data);

        for (GenericNode<T> neighbor : node.neighbors) {
            if (!visited.contains(neighbor)) {
                dfsRecursive(neighbor, visited, visitedNodes);
            }
        }
    }

    // Method to perform in-order traversal using the Node class
    public static List<Integer> inOrderTraversal(GenericNode root) {
        List<Integer> result = new ArrayList<>();
                    inOrderTraversalHelper(root, result);
        return result;
    }

    private static void inOrderTraversalHelper(GenericNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        inOrderTraversalHelper(node.left, result);
        result.add(node.data);
        inOrderTraversalHelper(node.right, result);
    }

    // Method to perform Dijkstra's algorithm using the Node class
    public static Map<GenericNode, Integer> dijkstra(Map<GenericNode, Map<GenericNode, Integer>> graph, GenericNode source) {
        Map<GenericNode, Integer> distances = new HashMap<>();
        Set<GenericNode> visited = new HashSet<>();
        PriorityQueue<NodeDistancePair> pq = new PriorityQueue<>(Comparator.comparingInt(pair -> pair.distance));

        for (GenericNode node : graph.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(source, 0);
        pq.offer(new NodeDistancePair(source, 0));

        while (!pq.isEmpty()) {
            NodeDistancePair currentPair = pq.poll();
            Generic Node currentNode = currentPair.node;
            int currentDistance = currentPair.distance;

            if (visited.contains(currentNode)) continue;
            visited.add(currentNode);

            for (Map.Entry<GenericNode, Integer> neighborEntry : graph.get(currentNode).entrySet()) {
                GenericNode neighborNode = neighborEntry.getKey();
                int weight = neighborEntry.getValue();
                int newDistance = currentDistance + weight;

                if (newDistance < distances.get(neighborNode)) {
                    distances.put(neighborNode, newDistance);
                    pq.offer(new NodeDistancePair(neighborNode, newDistance));
                }
            }
        }

        return distances;
    }

    // Helper class to store node-distance pairs for Dijkstra's algorithm
    public static class NodeDistancePair {
        GenericNode node;
        int distance;

        NodeDistancePair(GenericNode node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
}
