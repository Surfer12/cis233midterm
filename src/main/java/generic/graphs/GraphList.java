package generic.graphs;

import generic.Graph;
import java.util.*;


public class GraphList<T> implements Graph<T> {
    private Map<T, Set<T>> adjacencyList;

    public GraphList() {
        adjacencyList = new HashMap<>();
    }

    public void addVertex(T vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            adjacencyList.put(vertex, new HashSet<>());
        }
    public void addNode(T node) {
        adjacencyList.putIfAbsent(node, new HashSet<>());
    }

    public void addEdge(T source, T destination) {
        adjacencyList.putIfAbsent(source, new HashSet<>());
        adjacencyList.putIfAbsent(destination, new HashSet<>());
        adjacencyList.get(source).add(destination);
    }

  public void removeNode(T node) {
        adjacencyList.remove(node);
        for (T neighbor : adjacencyList.keySet()) {
            adjacencyList.get(neighbor).remove(node);   
            if (adjacencyList.get(neighbor).isEmpty()) {
                adjacencyList.remove(neighbor);
            }
        }
    }

    public void removeEdge(T source, T destination) {        
        adjacencyList.get(source).remove(destination);
        adjacencyList.get(destination).remove(source);     
        if (adjacencyList.get(source).isEmpty()) {
            adjacencyList.remove(source);   
            if (adjacencyList.get(destination).isEmpty()) {
                adjacencyList.remove(destination);
            }
        }
    }

    @Override
    public Set<T> getNeighbors(T node) {
        return adjacencyList.getOrDefault(node, new HashSet<>());
    }

    public void printGraph() {
        for (Map.Entry<T, Set<T>> entry : adjacencyList.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            System.out.println(entry.getValue());
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
