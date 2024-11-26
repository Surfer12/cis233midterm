import generic.GenericNodeLombokTest;
import generic.graphs.WeightedGraphLombokTest;
import legacyalgo.DijkstraGeneric;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Using Builder pattern from Lombok
        WeightedGraphLombokTest graph = WeightedGraphLombokTest.builder()
            .vertices(6)
            .build();

        // Initialize adjacency list
        for (int i = 0; i < 6; i++) {
            graph.getAdjList().add(new ArrayList<>());
        }

        // Add edges
        graph.addEdge(0, 1, 7);
        graph.addEdge(0, 2, 9);
        graph.addEdge(0, 5, 14);
        graph.addEdge(1, 2, 10);
        graph.addEdge(1, 3, 15);
        graph.addEdge(2, 3, 11);
        graph.addEdge(2, 5, 2);
        graph.addEdge(3, 4, 6);
        graph.addEdge(4, 5, 9);

        GenericNodeLombokTest<Integer> source = new GenericNodeLombokTest<>(0);
        GenericNodeLombokTest<Integer> destination = new GenericNodeLombokTest<>(5);
        
        Map<GenericNodeLombokTest<Integer>, Integer> distances = DijkstraGeneric.dijkstra(graph, source, destination);

        System.out.println("The shortest path from node 0 to node 5 is " + distances.get(destination));
    }
}
