import java.util.HashSet;
import java.util.Set;

import graphgetneighbors;

public class GenericDFS<T> implements graphgetneighbors<T> {

    @Override
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
}