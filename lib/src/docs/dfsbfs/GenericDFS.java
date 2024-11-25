import java.util.HashSet;
import java.util.Set;

public class GenericDFS<T> {

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

interface Graph<T> {
    Set<T> getNeighbors(T node);
}
