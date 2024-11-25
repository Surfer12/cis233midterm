
import java.util.Arrays;

class GraphMatrix {
    private int vertices;
    private int[][] adjacencyMatrix;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyMatrix = new int[vertices][vertices];
    }

    public void addEdge(int source, int destination) {
        // For an unweighted graph, simply mark the connection:
        adjacencyMatrix[source][destination] = 1; 

        // For an undirected graph, add the reverse edge as well:
        adjacencyMatrix[destination][source] = 1; 

        // For a weighted graph, add the weight instead of 1:
        // adjacencyMatrix[source][destination] = weight;
        // adjacencyMatrix[destination][source] = weight; 
    }

    public void removeEdge(int source, int destination) {
        adjacencyMatrix[source][destination] = 0;
        adjacencyMatrix[destination][source] = 0; // For undirected graph
    }

    public boolean hasEdge(int source, int destination) {
        return adjacencyMatrix[source][destination] != 0;
    }

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
        Graph graph = new Graph(5);
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
