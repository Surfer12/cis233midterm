public class DijkstraGeneric {
import java.util.*;

public class DijkstraGeneric {

    public static int[] dijkstra(WeightedGraph graph, int startVertex) {
        int vertices = graph.getVertices();
        int[] distances = new int[vertices];
        boolean[] visited = new boolean[vertices];

        PriorityQueue<WeightedGraph.Node> pq = new PriorityQueue<>();
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[startVertex] = 0;
        pq.add(new WeightedGraph.Node(startVertex, 0));

        while (!pq.isEmpty()) {
            int currentVertex = pq.poll().vertex;

            if (visited[currentVertex]) continue;
            visited[currentVertex] = true;

            List<WeightedGraph.Node> neighbors = graph.getAdjList().get(currentVertex);
            for (WeightedGraph.Node neighbor : neighbors) {
                int newDist = distances[currentVertex] + neighbor.weight;

                if (newDist < distances[neighbor.vertex]) {
                    distances[neighbor.vertex] = newDist;
                    pq.add(new WeightedGraph.Node(neighbor.vertex, newDist));
                }
            }
        }

        return distances;
    }
}
    
}
