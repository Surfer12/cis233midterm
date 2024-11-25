

import java.util.HashMap;
import java.util.Map;

// The graph shows:

// 6 vertices (1-6)
// 5 directed edges with weights:
// 1→2 (weight 4)
// 1→3 (weight 2)
//  2→4 (weight 5)
// 2→5 (weight 1)
// 3→6 (weight 3)

// Vertices 4, 5, and 6 have no outgoing edges

// NB: It is a weighted graph

public class WeightedGraph {
    public static void main(String[] args) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
                
        // Add edges as per the given graph
        graph.put(0, new HashMap<>(Map.of(1, 4, 6, 7))); // Node 0 connected to 1 (weight 4) and 6 (weight 7)
        graph.put(1, new HashMap<>(Map.of(0, 4, 2, 9, 6, 11))); // Node 1 connected to 0, 2, and 6
        graph.put(2, new HashMap<>(Map.of(1, 9, 3, 6, 4, 2))); // Node 2 connected to 1, 3, and 4
        graph.put(3, new HashMap<>(Map.of(2, 6, 4, 10, 5, 15))); // Node 3 connected to 2, 4, and 5
        graph.put(4, new HashMap<>(Map.of(2, 2, 3, 10, 5, 5, 7, 1, 8, 12))); // Node 4 connected to multiple nodes
        graph.put(5, new HashMap<>(Map.of(3, 15, 4, 5, 8, 12))); // Node 5 connected to 3, 4, and 8
        graph.put(6, new HashMap<>(Map.of(0, 7, 1, 11, 7, 1))); // Node 6 connected to 0, 1, and 7
        graph.put(7, new HashMap<>(Map.of(4, 1, 6, 1, 8, 3))); // Node 7 connected to 4, 6, and 8
        graph.put(8, new HashMap<>(Map.of(4, 12, 5, 12, 7, 3))); // Node 8 connected to 4, 5, and 7
        
        // Print the graph
        System.out.println("Graph representation (Adjacency Map):");
        for (var entry : graph.entrySet()) {
            System.out.println("Node " + entry.getKey() + " connected to: " + entry.getValue());
        }
    }
}
