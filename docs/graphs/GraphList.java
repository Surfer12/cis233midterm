import java.util.*;

class GraphList {
    private int vertices;
    private LinkedList<Integer>[] adjList;

    public GraphList(int vertices) {
        this.vertices = vertices;
        adjList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination) {
        adjList[source].add(destination);

        // For an undirected graph, add the reverse edge:
        adjList[destination].add(source); 
    }

    public void removeEdge(int source, int destination) {
        adjList[source].remove(Integer.valueOf(destination)); // Remove by value
        adjList[destination].remove(Integer.valueOf(source)); // For undirected
    }

    public boolean hasEdge(int source, int destination) {
        return adjList[source].contains(destination);
    }

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