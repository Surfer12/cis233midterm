/**
 * This class represents a graph using an adjacency matrix.
 */
class GraphMatrix {
    private final int vertices;
    private final int[][] adjacencyMatrix;

    /**
     * Constructs a graph with the specified number of vertices.
     * 
     * @param vertices The number of vertices in the graph.
     */
    public GraphMatrix(int vertices) {
        this.vertices = vertices;
        adjacencyMatrix = new int[vertices][vertices];
    }

    /**
     * Adds an edge between the source and destination vertices.
     * 
     * @param source The source vertex.
     * @param destination The destination vertex.
     * 
     * Time Complexity: O(1)
     */
    public void addEdge(int source, int destination) {
        // For an unweighted graph, simply mark the connection:
        adjacencyMatrix[source][destination] = 1; 

        // For an undirected graph, add the reverse edge as well:
        adjacencyMatrix[destination][source] = 1; 

        // For a weighted graph, add the weight instead of 1:
        // adjacencyMatrix[source][destination] = weight;
        // adjacencyMatrix[destination][source] = weight; 
    }

    /**
     * Removes the edge between the source and destination vertices.
     * 
     * @param source The source vertex.
     * @param destination The destination vertex.
     * 
     * Time Complexity: O(1)
     */
    public void removeEdge(int source, int destination) {
        adjacencyMatrix[source][destination] = 0;
        adjacencyMatrix[destination][source] = 0; // For undirected graph
    }

    /**
     * Checks if there is an edge between the source and destination vertices.
     * 
     * @param source The source vertex.
     * @param destination The destination vertex.
     * @return true if there is an edge between the source and destination vertices, false otherwise.
     * 
     * Time Complexity: O(1)
     */
    public boolean hasEdge(int source, int destination) {
        return adjacencyMatrix[source][destination] != 0;
    }

    /**
     * Prints the graph.
     * 
     * Time Complexity: O(V^2), where V is the number of vertices in the graph.
     */
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
        GraphMatrix graph = new GraphMatrix(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.printGraph();
    }
}
