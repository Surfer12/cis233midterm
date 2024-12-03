package generic;
import java.util.Set;

public interface Graph<T> {    
    void dfs(T node, Set<T> visited, Graph<T> graph);
    void addVertex(T vertex);
    void addEdge(T source, T destination);
    void addEdge(T source, T destination, int weight);
    void removeVertex(T vertex);
    void removeEdge(T source, T destination);
    Set<T> getNeighbors(T node);
    void printGraph();
}