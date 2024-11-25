package generic.graphs;

import java.util.*;

public class GraphList<T> implements Graph<T> {
    private Map<T, List<T>> adjList;

    public GraphList() {
        adjList = new HashMap<>();
    }

    public void addVertex(T vertex) {
        if (!adjList.containsKey(vertex)) {
            adjList.put(vertex, new ArrayList<>());
        }
    }

    public void addEdge(T source, T destination) {
        addVertex(source);
        addVertex(destination);
        adjList.get(source).add(destination);
        adjList.get(destination).add(source); // For undirected graph
    }

    public void removeEdge(T source, T destination) {
        if (adjList.containsKey(source) && adjList.containsKey(destination)) {
            adjList.get(source).remove(destination);
            adjList.get(destination).remove(source);
        }
    }

    public boolean hasEdge(T source, T destination) {
        return adjList.containsKey(source) && adjList.get(source).contains(destination);
    }

    public List<T> getNeighbors(T vertex) {
        return adjList.getOrDefault(vertex, new ArrayList<>());
    }

    public void printGraph() {
        for (T vertex : adjList.keySet()) {
            System.out.print("Vertex " + vertex + " is connected to: ");
            for (T neighbor : adjList.get(vertex)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GraphList<Integer> graph = new GraphList<>();
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
