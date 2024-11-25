package lib/src/main/java/cis233midterm;

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
        graph.put(1, new HashMap<>(Map.of(2, 4, 3, 2))); 
        graph.put(2, new HashMap<>(Map.of(4, 5, 5, 1))); 
        graph.put(3, new HashMap<>(Map.of(6, 3))); 
        graph.put(4, new HashMap<>()); 
        graph.put(5, new HashMap<>()); 
        graph.put(6, new HashMap<>());

        // Ensure the graph is not null before printing
        if (graph != null) {
            System.out.println(graph);
        }
    }
}

