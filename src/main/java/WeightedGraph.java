public class WeightedGraph {
import java.util.ArrayList;
import java.util.List;

public class WeightedGraph {
    private int vertices;
    private List<List<Edge>> adjacencyList;

    public WeightedGraph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    // ...existing code...
}
    
}
