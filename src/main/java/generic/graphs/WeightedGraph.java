package generic.graphs;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

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

public class WeightedGraph implements Graph<Integer> {
    private int vertices;
    private List<List<Edge>> adjacencyList;

    public WeightedGraph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public static void main(String[] args) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
                
        // Add edges as per the given graph
        graph.put(1, new HashMap<>(Map.of(2, 4, 3, 2))); // Node 1 connected to 2 (weight 4) and 3 (weight 2)
        graph.put(2, new HashMap<>(Map.of(4, 5, 5, 1))); // Node 2 connected to 4 (weight 5) and 5 (weight 1)
        graph.put(3, new HashMap<>(Map.of(6, 3))); // Node 3 connected to 6 (weight 3)
        graph.put(4, new HashMap<>()); // Node 4 has no outgoing edges
        graph.put(5, new HashMap<>()); // Node 5 has no outgoing edges
        graph.put(6, new HashMap<>()); // Node 6 has no outgoing edges
        
        // Print the graph
        System.out.println("Graph representation (Adjacency Map):");
        for (var entry : graph.entrySet()) {
            System.out.println("Node " + entry.getKey() + " connected to: " + entry.getValue());
        }
    }

    @Override
    public void addVertex(Integer vertex) {
        // Implementation
    }

    @Override
    public void addEdge(Integer source, Integer destination) {
        // Implementation
    }

    @Override
    public void addEdge(Integer source, Integer destination, int weight) {
        // Implementation to add weighted edge
    }

    @Override
    public void removeVertex(Integer vertex) {
        // Implementation
    }

    @Override
    public void removeEdge(Integer source, Integer destination) {
        // Implementation
    }

    @Override
    public Set<Integer> getNeighbors(Integer vertex) {
        // Implementation
    }

    @Override
    public void printGraph() {
        // Implementation
    }
}
