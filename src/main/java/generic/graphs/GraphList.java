package generic.graphs;

import java.util.*;

class GraphList<T> {
    private final int vertices;
    private final LinkedList<T>[] adjList;

    public GraphList(int vertices) {
        this.vertices = vertices;
        adjList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(T source, T destination) {
        adjList[source].add(destination);

        // For an undirected graph, add the reverse edge:
        adjList[destination].add(source); 
    }

    public void removeEdge(T source, T destination) {
        adjList[source].remove(destination); // Remove by value
        adjList[destination].remove(destination); // For undirected
    }

    public boolean hasEdge(T source, T destination) {
        return adjList[source].contains(destination);
    }

    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print("Vertex " + i + " is connected to: ");
            for (T neighbor : adjList[i]) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GraphList<Integer> graph = new GraphList<>(5);
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
