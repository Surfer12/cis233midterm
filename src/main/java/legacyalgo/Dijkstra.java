// Dijkstra's algorithm for shortest path
/* Task 1- Homework
• Use Dijkstra's algorithm to find the shortest path and its total distance
from Node 0 to Node 5 in the graph shown below. You are required to
submit a pdf document. */

package legacyalgo;

import generic.GenericNode;
import generic.GenericTraversal;
import java.util.*;

public class Dijkstra {

    public static <T> Map<GenericNode<T>, Integer> dijkstra(Map<GenericNode<T>, Map<GenericNode<T>, Integer>> graph, GenericNode<T> source) {
        GenericTraversal<T> traversal = new GenericTraversal<>();
        return traversal.dijkstra(graph, source);
    }

// Class to represent the graph and Dijkstra's Algorithm
class Graph {
    private final int vertices; // Number of vertices
    private final List<List<Node>> adjList; // Adjacency List for the graph

    // Constructor
    public Graph(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    // Method to add edges to the graph
    public void addEdge(int source, int destination, int weight) {
        adjList.get(source).add(new Node(destination, weight));
        adjList.get(destination).add(new Node(source, weight)); // Since the graph is undirected
    }

    // Dijkstra's Algorithm implementation
    public void dijkstra(int startVertex, int endVertex) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
        int[] distances = new int[vertices];
        int[] predecessors = new int[vertices]; // To track the path

        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(predecessors, -1);
        distances[startVertex] = 0;

        pq.add(new Node(startVertex, 0));

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            int currentVertex = currentNode.vertex;

            for (Node neighbor : adjList.get(currentVertex)) {
                int newDist = distances[currentVertex] + neighbor.weight;

                if (newDist < distances[neighbor.vertex]) {
                    distances[neighbor.vertex] = newDist;
                    predecessors[neighbor.vertex] = currentVertex;
                    pq.add(new Node(neighbor.vertex, newDist));
                }
            }
        }

        // Print the shortest path and its distance
        System.out.println("Shortest path from " + startVertex + " to " + endVertex + ":");
        printPath(predecessors, endVertex);
        System.out.println("\nTotal Distance: " + distances[endVertex]);
    }

    // Helper method to print the path
    private void printPath(int[] predecessors, int currentVertex) {
        if (predecessors[currentVertex] == -1) {
            System.out.print(currentVertex);
            return;
        }
        printPath(predecessors, predecessors[currentVertex]);
        System.out.print(" -> " + currentVertex);
    }

    // Node class to store graph edges
    static class Node {
        int vertex, weight;

        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {


    
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        
        // Add edges as per the given graph
        graph.put(0, new HashMap<>(Map.of(1, 4, 6, 7))); // Node 0 connected to 1 (weight 4) and 6 (weight 7)
        graph.put(1, new HashMap<>(Map.of(0, 4, 2, 9, 6, 11))); // Node 1 connected to 0, 2, and 6
        graph.put(2, new HashMap<>(Map.of(1, 9, 3, 6, 4, 2))); // Node 2 connected to 1, 3, and 4
        graph.put(3, new HashMap<>(Map.of(2, 6, 4, 10, 5, 15))); // Node 3 connected to 2, 4, and 5
        graph.put(4, new HashMap<>(Map.of(2, 2, 3, 10, 5, 5, 7, 1, 8, 12))); // Node 4 connected to multiple nodes
        graph.put(5, new HashMap<>(Map.of(3, 15, 4, 5, 8, 12))); // Node 5 connected to 3, 4, and 8
        graph.put(6, new HashMap<>(Map.of(0, 7, 1, 11, 7, 1))); // Node 6 connected to 0, 1, and 7
        graph.put(7, new HashMap<>(Map.of(4, 1, 6, 1, 8, 3))); // Node 7 connected to 4, 6, and 8
        graph.put(8, new HashMap<>(Map.of(4, 12, 5, 12, 7, 3))); // Node 8 connected to 4, 5, and 7

        // Print the graph
        System.out.println("Graph representation (Adjacency Map):");
        for (var entry : graph.entrySet()) {
            System.out.println("Node " + entry.getKey() + " connected to: " + entry.getValue());
        }
    }
    
        GenericNode sourceNode = node1; // Choose a source node
        Map<GenericNode, Integer> shortestDistances = dijkstra(graph, sourceNode);

        System.out.println("Shortest distances from node " + sourceNode.getData() + ":");
        for (Map.Entry<GenericNode, Integer> entry : shortestDistances.entrySet()) {
            System.out.println("To node " + entry.getKey().getData() + ": " + entry.getValue());
        }
    }
