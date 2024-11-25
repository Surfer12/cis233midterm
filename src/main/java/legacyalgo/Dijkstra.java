import java.util.*;
import cis233midterm.Node;
import cis233midterm.GenericTraversal;
public class Dijkstra {

    public static Map<Node, Integer> dijkstra(Map<Node, Map<Node, Integer>> graph, Node source) {
        return GenericTraversal.dijkstra(graph, source);
    }

    // Example usage (add this to your main method or a separate test method)
    public static void main(String[] args) {
        // Create a sample graph (adjacency list representation)
        Map<Node, Map<Node, Integer>> graph = new HashMap<>();
        
        // Add nodes and edges with weights
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        node1.neighbors.add(node2);
        node1.neighbors.add(node3);
        node2.neighbors.add(node4);
        node2.neighbors.add(node5);
        node3.neighbors.add(node6);

        graph.put(node1, new HashMap<>(Map.of(node2, 4, node3, 2)));
        graph.put(node2, new HashMap<>(Map.of(node4, 5, node5, 1)));
        graph.put(node3, new HashMap<>(Map.of(node6, 3)));
        graph.put(node4, new HashMap<>());
        graph.put(node5, new HashMap<>());
        graph.put(node6, new HashMap<>());

        Node sourceNode = node1; // Choose a source node
        Map<Node, Integer> shortestDistances = dijkstra(graph, sourceNode);

        System.out.println("Shortest distances from node " + sourceNode.data + ":");
        for (Map.Entry<Node, Integer> entry : shortestDistances.entrySet()) {
            System.out.println("To node " + entry.getKey().data + ": " + entry.getValue());
        }
    }
}
