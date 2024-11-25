
package generic.graphs;

import java.util.Set;

public interface Graph<T> {
    void addVertex(T vertex);
    void addEdge(T source, T destination, int weight); // Updated method signature
    void removeVertex(T vertex);
    void removeEdge(T source, T destination);
    Set<T> getNeighbors(T vertex);
    void printGraph();

    public int getVertices();

    public Object getAdjList();
}
