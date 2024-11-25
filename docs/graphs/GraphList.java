import java.util.*;

/**
 * This class represents a graph using an adjacency list.
 */
class GraphList {
    private final int vertices;
    private final LinkedList<Integer>[] adjList;

    /**
     * Constructs a graph with the specified number of vertices.
     * 
     * @param vertices The number of vertices in the graph.
     */
    public GraphList(int vertices) {
        this.vertices = vertices;
        adjList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new LinkedList<>();
        }
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
        adjList[source].add(destination);

        // For an undirected graph, add the reverse edge:
        adjList[destination].add(source); 
    }

    /**
     * Removes the edge between the source and destination vertices.
     * 
     * @param source The source vertex.
     * @param destination The destination vertex.
     * 
     * Time Complexity: O(E), where E is the number of edges in the graph.
     */
    public void removeEdge(int source, int destination) {
        adjList[source].remove(Integer.valueOf(destination)); // Remove by value
        adjList[destination].remove(Integer.valueOf(source)); // For undirected
    }

    /**
     * Checks if there is an edge between the source and destination vertices.
     * 
     * @param source The source vertex.
     * @param destination The destination vertex.
     * @return true if there is an edge between the source and destination vertices, false otherwise.
     * 
     * Time Complexity: O(E), where E is the number of edges in the graph.
     */
    public boolean hasEdge(int source, int destination) {
        return adjList[source].contains(destination);
    }

    /**
     * Prints the graph.
     * 
     * Time Complexity: O(V + E), where V is the number of vertices and E is the number of edges in the graph.
     */
    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print("Vertex " + i + " is connected to: ");
            for (int neighbor : adjList[i]) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GraphList graph = new GraphList(5);
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
