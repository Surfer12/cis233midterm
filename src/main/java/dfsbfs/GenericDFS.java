package dfsbfs;

import java.util.*;
import generic.Graph;

public class GenericDFS<T> implements Graph<T> {
    private Map<T, Set<T>> adjacencyList = new HashMap<>();
    
    public void dfs(T node, Set<T> visited, Graph<T> graph) {
        if (node == null) return;

        visited.add(node);
        System.out.print(node + " ");

        for (T neighbor : graph.getNeighbors(node)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, visited, graph);
            }
        }
    }

    @Override
    public Set<T> getNeighbors(T node) {
        return adjacencyList.getOrDefault(node, new HashSet<>());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GenericDFS)) return false;
        GenericDFS<?> that = (GenericDFS<?>) o;
        return Objects.equals(adjacencyList, that.adjacencyList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adjacencyList);
    }
}