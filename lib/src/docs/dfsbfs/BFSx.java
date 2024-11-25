import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BFSx {

    public static void bfs(Map<Integer, Map<Integer, Integer>> graph, int startNode) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(startNode);
        queue.offer(startNode);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            System.out.print(currentNode + " ");

            for (int neighbor : graph.get(currentNode).keySet()) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
    }
    public static void main(String[] args) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        graph.put(1, new HashMap<>(Map.of(2, 4, 3, 2))); 
        graph.put(2, new HashMap<>(Map.of(4, 5, 5, 1))); 
        graph.put(3, new HashMap<>(Map.of(6, 3))); 
        graph.put(4, new HashMap<>()); 
        graph.put(5, new HashMap<>()); 
        graph.put(6, new HashMap<>());


        int startNode = 1; // Choose your starting node
        bfs(graph, startNode);
    }
}