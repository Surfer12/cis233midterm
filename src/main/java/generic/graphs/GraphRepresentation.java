package generic.graphs;

import generic.Graph;
import java.util.*;


public class GraphRepresentation<T> implements Graph<T> {
    private Map<T, Set<T>> adjacencyGraph;

    public GraphRepresentation() {
        adjacencyGraph = new HashMap<>();
    }

    @Override
    public void addVertex(T vertex) {
        if (!adjacencyGraph.containsKey(vertex)) {
            adjacencyGraph.put(vertex, new HashSet<>());
            System.out.println("Vertex " + vertex + " added to graph");
        }
    }

    // Remove @Override since this method does not exist in the Graph interface
    public void addEdge(T source, T destination) {
        adjacencyGraph.putIfAbsent(source, new HashSet<>());
        adjacencyGraph.putIfAbsent(destination, new HashSet<>());
        adjacencyGraph.get(source).add(destination);
    }

    @Override
    public void addEdge(T source, T destination, int weight) {
        // Implementation for weighted graph can be added here
        // For now, we'll ignore the weight and call the existing addEdge
        addEdge(source, destination);
    }

    @Override
    public void removeVertex(T vertex) {
        adjacencyGraph.remove(vertex);
        for (T neighbor : adjacencyGraph.keySet()) {
            adjacencyGraph.get(neighbor).remove(vertex);   
            if (adjacencyGraph.get(neighbor).isEmpty()) {
                adjacencyGraph.remove(neighbor);
            }
        }
    }

    @Override
    public void removeEdge(T source, T destination) {        
        adjacencyGraph.get(source).remove(destination);
        adjacencyGraph.get(destination).remove(source);     
    }

    @Override
    public int getVertices() {
        return adjacencyGraph.getOrDefault(this, defaultValue)
    }

    @Override
    public Set<T> getNeighbors(T node) {
        return adjacencyGraph.getOrDefault(node, new HashSet<>());
    }

    @Override
    public void printGraph() {
        for (Map.Entry<T, Set<T>> entry : adjacencyGraph.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            System.out.println(entry.getValue());
        }
    }

    public static void main(String[] args) {
        GraphRepresentation<Integer> graph = new GraphRepresentation<>();
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
