import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class GenericBFS<T> {

    public void bfs(T node, Queue<T> queue, Set<T> visited, Graph<T> graph) {
        if (node == null) return;

        queue.offer(node);
        visited.add(node);

        while (!queue.isEmpty()) {
            T current = queue.poll();
            System.out.print(current + " ");

            for (T neighbor : graph.getNeighbors(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
    }
}

interface Graph<T> {
    Set<T> getNeighbors(T node);
}
