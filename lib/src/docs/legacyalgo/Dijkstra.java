import java.util.*;

public class Dijkstra {

    public static Map<Integer, Integer> dijkstra(Map<Integer, Map<Integer, Integer>> graph, int source) {
        Map<Integer, Integer> distances = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1])); 

        for (int node : graph.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(source, 0);
        pq.offer(new int[]{source, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currNode = curr[0];
            int currDist = curr[1];

            if (visited.contains(currNode)) continue;
            visited.add(currNode);

            for (Map.Entry<Integer, Integer> neighbor : graph.get(currNode).entrySet()) {
                int neighborNode = neighbor.getKey();
                int weight = neighbor.getValue();
                int newDist = currDist + weight;

                if (newDist < distances.get(neighborNode)) {
                    distances.put(neighborNode, newDist);
                    pq.offer(new int[]{neighborNode, newDist});
                }
            }
        }
        return distances;
    }

    // Example usage (add this to your main method or a separate test method)
    public static void main(String[] args) {
        // Create a sample graph (adjacency list representation)
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        
         // Add nodes and edges with weights
         graph.put(1, new HashMap<>(Map.of(2, 4, 3, 2))); // Node 1 connected to 2 (weight 4) and 3 (weight 2)
         graph.put(2, new HashMap<>(Map.of(4, 5, 5, 1))); // Node 2 connected to 4 (weight 5) and 5 (weight 1)
         graph.put(3, new HashMap<>(Map.of(6, 3))); // Node 3 connected to 6 (weight 3)
         graph.put(4, new HashMap<>()); // No neighbors for node 4
         graph.put(5, new HashMap<>()); // No neighbors for node 5
         graph.put(6, new HashMap<>()); // No neighbors for node 6

        int sourceNode = 1; // Choose a source node
        Map<Integer, Integer> shortestDistances = dijkstra(graph, sourceNode);

        System.out.println("Shortest distances from node " + sourceNode + ":");
        for (Map.Entry<Integer, Integer> entry : shortestDistances.entrySet()) {
            System.out.println("To node " + entry.getKey() + ": " + entry.getValue());
        }
    }
}