import java.util.*;

/**
 * A class that implements Breadth-First Search (BFS) algorithm for graph traversal.
 * BFS explores all vertices of a graph at the present depth before moving on to vertices at the next depth level.
 */

 
public class BFS {

    // Method to perform Breadth-First Search on a graph
    public static List<Integer> bfs(Map<Integer, List<Integer>> graph, int startNode) {
        return GenericTraversal.bfs(new Node(startNode));
    }

    public static void main(String[] args) {
        // Sample graph represented as an adjacency list
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 4, 6));
        graph.put(1, Arrays.asList(0, 2, 7));
        graph.put(2, Arrays.asList(1));
        graph.put(3, Arrays.asList(4, 5));
        graph.put(4, Arrays.asList(0, 3, 8));
        graph.put(5, Arrays.asList(3));
        graph.put(6, Arrays.asList(0, 7));
        graph.put(7, Arrays.asList(1, 6));
        graph.put(8, Arrays.asList(4));

        int startNode = 0; // Starting node for BFS traversal
        List<Integer> bfsTraversal = bfs(graph, startNode); // Perform BFS

        System.out.println("BFS Traversal: " + bfsTraversal); // Print the traversal order
    }
}
