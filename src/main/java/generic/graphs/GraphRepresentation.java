package generic.graphs;

import generic.Graph;
import java.util.*;

public class GraphRepresentation<T> implements Graph<T> {
    private Map<T, Set<T>> adjacencyGraph;
    private Map<T, Map<T, Integer>> weightedAdjacencyGraph;

    public GraphRepresentation() {
        adjacencyGraph = new HashMap<>();
        weightedAdjacencyGraph = new HashMap<>();
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
        if (!adjacencyGraph.containsKey(vertex)) {
            adjacencyGraph.put(vertex, new HashSet<>());
            weightedAdjacencyGraph.put(vertex, new HashMap<>());
            System.out.println("Vertex " + vertex + " added to graph");
        }
    }

    @Override
    public void addEdge(T source, T destination) {
        adjacencyGraph.putIfAbsent(source, new HashSet<>());
        adjacencyGraph.putIfAbsent(destination, new HashSet<>());
        adjacencyGraph.get(source).add(destination);
        adjacencyGraph.get(destination).add(source);
    }

    @Override
    public void addEdge(T source, T destination, int weight) {
        adjacencyGraph.putIfAbsent(source, new HashSet<>());
        adjacencyGraph.putIfAbsent(destination, new HashSet<>());
        adjacencyGraph.get(source).add(destination);
        adjacencyGraph.get(destination).add(source);

        weightedAdjacencyGraph.putIfAbsent(source, new HashMap<>());
        weightedAdjacencyGraph.putIfAbsent(destination, new HashMap<>());
        weightedAdjacencyGraph.get(source).put(destination, weight);
        weightedAdjacencyGraph.get(destination).put(source, weight);
    }

    @Override
    public void removeVertex(T vertex) {
        adjacencyGraph.remove(vertex);
        weightedAdjacencyGraph.remove(vertex);

        for (T neighbor : adjacencyGraph.keySet()) {
            adjacencyGraph.get(neighbor).remove(vertex);
            weightedAdjacencyGraph.get(neighbor).remove(vertex);

            if (adjacencyGraph.get(neighbor).isEmpty()) {
                adjacencyGraph.remove(neighbor);
                weightedAdjacencyGraph.remove(neighbor);
            }
        }
    }

    @Override
    public void removeEdge(T source, T destination) {
        adjacencyGraph.get(source).remove(destination);
        adjacencyGraph.get(destination).remove(source);

        weightedAdjacencyGraph.get(source).remove(destination);
        weightedAdjacencyGraph.get(destination).remove(source);
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
