package generic.graphs;

import generic.Graph;
import java.util.HashSet;
import java.util.Set;

public class GraphMatrix<T> implements Graph<T> {
    private final int vertices;
    private final int[][] adjacencyMatrix;
    private final int[][] weightMatrix;

    public GraphMatrix(int vertices) {
        this.vertices = vertices;
        adjacencyMatrix = new int[vertices][vertices];
        weightMatrix = new int[vertices][vertices];
    }

    @Override
    public void dfs(T node, Set<T> visited, Graph<T> graph) {
        if (node == null)
            return;

        visited.add(node);
        System.out.print(node + " ");

        for (T neighbor : graph.getNeighbors(node)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, visited, graph);
            }
        }
    }

    @Override
    public void addVertex(T vertex) {
        // In matrix representation, vertices are pre-allocated
        System.out.println("Vertex " + vertex + " added");
    }

    @Override
    public void addEdge(T source, T destination) {
        int src = (int) source;
        int dest = (int) destination;
        adjacencyMatrix[src][dest] = 1;
        adjacencyMatrix[dest][src] = 1;
    }

    @Override
    public void addEdge(T source, T destination, int weight) {
        int src = (int) source;
        int dest = (int) destination;
        adjacencyMatrix[src][dest] = 1;
        adjacencyMatrix[dest][src] = 1;
        weightMatrix[src][dest] = weight;
        weightMatrix[dest][src] = weight;
    }

    @Override
    public void removeVertex(T vertex) {
        int v = (int) vertex;
        for (int i = 0; i < vertices; i++) {
            adjacencyMatrix[v][i] = 0;
            adjacencyMatrix[i][v] = 0;
            weightMatrix[v][i] = 0;
            weightMatrix[i][v] = 0;
        }
    }

    @Override
    public void removeEdge(T source, T destination) {
        int src = (int) source;
        int dest = (int) destination;
        adjacencyMatrix[src][dest] = 0;
        adjacencyMatrix[dest][src] = 0;
        weightMatrix[src][dest] = 0;
        weightMatrix[dest][src] = 0;
    }

    @Override
    public Set<T> getNeighbors(T vertex) {
        Set<T> neighbors = new HashSet<>();
        int v = ((Number) vertex).intValue();
        for (int i = 0; i < vertices; i++) {
            if (adjacencyMatrix[v][i] != 0) {
                @SuppressWarnings("unchecked")
                T neighborVertex = (T) Integer.valueOf(i);
                neighbors.add(neighborVertex);
            }
        }
        return neighbors;
    }

    @Override
    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print("Vertex " + i + " is connected to: ");
            for (int j = 0; j < vertices; j++) {
                if (adjacencyMatrix[i][j] != 0) {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GraphMatrix<Integer> graph = new GraphMatrix<>(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.printGraph();

        // Demonstrate DFS
        System.out.println("\nDepth-First Search starting from vertex 0:");
        Set<Integer> visited = new HashSet<>();
        graph.dfs(0, visited, graph);
    }
}
