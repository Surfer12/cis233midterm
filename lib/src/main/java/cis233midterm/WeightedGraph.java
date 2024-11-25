package cis233midterm;

import java.util.HashMap;
import java.util.Map;

// Given this code snippet, draw the graph representation and upload a picture of your graph.
// NB: It is a weighted graph

public class WeightedGraph {
    public static void main(String[] args) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        graph.put(1, new HashMap<>(Map.of(2, 4, 3, 2))); 
        graph.put(2, new HashMap<>(Map.of(4, 5, 5, 1))); 
        graph.put(3, new HashMap<>(Map.of(6, 3))); 
        graph.put(4, new HashMap<>()); 
        graph.put(5, new HashMap<>()); 
        graph.put(6, new HashMap<>());

        System.out.println(graph);
    }
}
