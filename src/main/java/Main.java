import generic.GenericNode;
import generic.graphs.WeightedGraph;
import generic.DijkstraGenericCopy;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Using Builder pattern from Lombok
        WeightedGraph graph = WeightedGraph.builder()
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

        GenericNode<Integer> source = new GenericNode<>(0);
        GenericNode<Integer> destination = new GenericNode<>(5);
        
        Map<GenericNode<Integer>, Integer> distances = DijkstraGenericCopy.dijkstra(graph, source, destination);

        System.out.println("The shortest path from node 0 to node 5 is " + distances.get(destination));
    }
}
