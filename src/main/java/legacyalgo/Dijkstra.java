// Dijkstra's algorithm for shortest path
/* Task 1- Homework
• Use Dijkstra's algorithm to find the shortest path and its total distance
from Node 0 to Node 5 in the graph shown below. You are required to
submit a pdf document. */

package legacyalgo;

import java.util.HashMap;
import java.util.Map;

import generic.GenericNode;
import generic.GenericTraversal;

public class Dijkstra {

    public static Map<GenericNode, Integer> dijkstra(Map<GenericNode, Map<GenericNode, Integer>> graph, GenericNode source) {
        return GenericTraversal.dijkstra(graph, source);
    }

    // Example usage (add this to your main method or a separate test method)
    public static void main(String[] args) {
        // Create a sample graph (adjacency list representation)
        Map<GenericNode, Map<GenericNode, Integer>> graph = new HashMap<>();
        
        // Add nodes and edges with weights
        GenericNode node1 = new GenericNode(1);
        GenericNode node2 = new GenericNode(2);
        GenericNode node3 = new GenericNode(3);
        GenericNode node4 = new GenericNode(4);
        GenericNode node5 = new GenericNode(5);
        GenericNode node6 = new GenericNode(6);

        node1.getNeighbors().add(node2);
        node1.getNeighbors().add(node3);
        node2.getNeighbors().add(node4);
        node2.getNeighbors().add(node5);
        node3.getNeighbors().add(node6);

        graph.put(node1, new HashMap<>(Map.of(node2, 4, node3, 2)));
        graph.put(node2, new HashMap<>(Map.of(node4, 5, node5, 1)));
        graph.put(node3, new HashMap<>(Map.of(node6, 3)));
        graph.put(node4, new HashMap<>());
        graph.put(node5, new HashMap<>());
        graph.put(node6, new HashMap<>());

        GenericNode sourceNode = node1; // Choose a source node
        Map<GenericNode, Integer> shortestDistances = dijkstra(graph, sourceNode);

        System.out.println("Shortest distances from node " + sourceNode.getData() + ":");
        for (Map.Entry<GenericNode, Integer> entry : shortestDistances.entrySet()) {
            System.out.println("To node " + entry.getKey().getData() + ": " + entry.getValue());
        }
    }
}
