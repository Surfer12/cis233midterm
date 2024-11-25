package legacyalgo;

// Dijkstra's algorithm for shortest path
/* Task 1- Homework
• Use Dijkstra's algorithm to find the shortest path and its total distance
from Node 0 to Node 5 in the graph shown below. You are required to print the
shortest path and its total distance.

• The graph is represented by the adjacency list. The adjacency list for the
graph shown below is as follows:

Node 0: Node 1, Node 6
Node 1: Node 2, Node 6
Node 2: Node 3, Node 4
Node 3: Node 4
Node 4: Node 5, Node 7
Node 5: Node 8
Node 6: Node 7, Node 8
Node 7: Node 8
Node 8: None

• The graph is undirected. The shortest path from Node 0 to Node 5 is shown
below:

Shortest path from 0 to 5:
0 -> 1 -> 2 -> 3 -> 4 -> 5 (total distance: 15)

• The total distance is 15.
*/

import java.util.*;

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

    // Main method
    public static void main(String[] args) {
        Graph graph = new Graph(9); // 9 vertices in the graph (0 to 8)

        // Add edges as per the graph
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 6, 7);
        graph.addEdge(1, 2, 9);
        graph.addEdge(1, 6, 11);
        graph.addEdge(2, 3, 6);
        graph.addEdge(2, 4, 2);
        graph.addEdge(3, 4, 10);
        graph.addEdge(3, 5, 15);
        graph.addEdge(4, 5, 5);
        graph.addEdge(4, 7, 1);
        graph.addEdge(4, 8, 12);
        graph.addEdge(5, 8, 12);
        graph.addEdge(6, 7, 1);
        graph.addEdge(7, 8, 3);

        // Run Dijkstra's algorithm from node 0 to node 5
        graph.dijkstra(0, 5);
    }
}