

import java.util.*;

public class GenericTraversal {

    // Method to perform Breadth-First Search (BFS) traversal using the Node class
    public static List<Integer> bfs(Node startNode) {
        List<Integer> visitedNodes = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();

        queue.offer(startNode);
        visited.add(startNode);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            visitedNodes.add(currentNode.data);

            for (Node neighbor : currentNode.neighbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }

        return visitedNodes;
    }

    // Method to perform Depth-First Search (DFS) traversal using the Node class
    public static List<Integer> dfs(Node startNode) {
        List<Integer> visitedNodes = new ArrayList<>();
        Set<Node> visited = new HashSet<>();
        dfsRecursive(startNode, visited, visitedNodes);
        return visitedNodes;
    }

    private static void dfsRecursive(Node node, Set<Node> visited, List<Integer> visitedNodes) {
        visited.add(node);
        visitedNodes.add(node.data);

        for (Node neighbor : node.neighbors) {
            if (!visited.contains(neighbor)) {
                dfsRecursive(neighbor, visited, visitedNodes);
            }
        }
    }

    // Method to perform in-order traversal using the Node class
    public static List<Integer> inOrderTraversal(Node root) {
        List<Integer> result = new ArrayList<>();
        inOrderTraversalHelper(root, result);
        return result;
    }

    private static void inOrderTraversalHelper(Node node, List<Integer> result) {
        if (node == null) {
            return;
        }
        inOrderTraversalHelper(node.left, result);
        result.add(node.data);
        inOrderTraversalHelper(node.right, result);
    }

    // Method to perform Dijkstra's algorithm using the Node class
    public static Map<Node, Integer> dijkstra(Map<Node, Map<Node, Integer>> graph, Node source) {
        Map<Node, Integer> distances = new HashMap<>();
        Set<Node> visited = new HashSet<>();
        PriorityQueue<NodeDistancePair> pq = new PriorityQueue<>(Comparator.comparingInt(pair -> pair.distance));

        for (Node node : graph.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(source, 0);
        pq.offer(new NodeDistancePair(source, 0));

        while (!pq.isEmpty()) {
            NodeDistancePair currentPair = pq.poll();
            Node currentNode = currentPair.node;
            int currentDistance = currentPair.distance;

            if (visited.contains(currentNode)) continue;
            visited.add(currentNode);

            for (Map.Entry<Node, Integer> neighborEntry : graph.get(currentNode).entrySet()) {
                Node neighborNode = neighborEntry.getKey();
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
    private static class NodeDistancePair {
        Node node;
        int distance;

        NodeDistancePair(Node node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
}
