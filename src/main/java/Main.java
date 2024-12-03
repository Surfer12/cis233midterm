import generic.graphs.GraphRepresentation;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Create a weighted graph using GraphRepresentation
        GraphRepresentation<Integer> graph = new GraphRepresentation<>();

        // Add vertices
        for (int i = 0; i < 6; i++) {
            graph.addVertex(i);
        }

        // Add weighted edges
        graph.addEdge(0, 1, 7);
        graph.addEdge(0, 2, 9);
        graph.addEdge(0, 5, 14);
        graph.addEdge(1, 2, 10);
        graph.addEdge(1, 3, 15);
        graph.addEdge(2, 3, 11);
        graph.addEdge(2, 5, 2);
        graph.addEdge(3, 4, 6);
        graph.addEdge(4, 5, 9);

        // Print the graph
        System.out.println("Graph representation:");
        graph.printGraph();

        // Perform DFS starting from vertex 0
        System.out.println("\nDepth-First Search starting from vertex 0:");
        Set<Integer> visited = new HashSet<>();
        graph.dfs(0, visited, graph);
    }
}
