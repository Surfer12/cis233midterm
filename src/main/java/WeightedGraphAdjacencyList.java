import java.util.ArrayList;
import java.util.List;

public class WeightedGraphAdjacencyList {
    private int vertices;
    private List<List<Edge>> adjacencyList;

    // Inner class to represent an edge
    public class Edge {
        int destination;
        double weight;

        public Edge(int destination, double weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    public WeightedGraphAdjacencyList(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    // Add an edge to the graph (undirected)
    public void addEdge(int source, int destination, double weight) {
        // Add edge from source to destination
        adjacencyList.get(source).add(new Edge(destination, weight));
        
        // For undirected graph, add the reverse edge
        adjacencyList.get(destination).add(new Edge(source, weight));
    }

    // Add an edge to the graph (directed)
    public void addDirectedEdge(int source, int destination, double weight) {
        adjacencyList.get(source).add(new Edge(destination, weight));
    }

    // Get all edges connected to a vertex
    public List<Edge> getAdjacentEdges(int vertex) {
        return adjacencyList.get(vertex);
    }

    // Get the number of vertices
    public int getVertexCount() {
        return vertices;
    }

    // Print the graph (for debugging)
    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print("Vertex " + i + " is connected to: ");
            for (Edge edge : adjacencyList.get(i)) {
                System.out.print("(" + edge.destination + ", " + edge.weight + ") ");
            }
            System.out.println();
        }
    }
} 