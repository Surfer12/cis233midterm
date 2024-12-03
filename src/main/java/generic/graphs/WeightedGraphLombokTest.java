package generic.graphs;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WeightedGraphLombokTest {
    @Builder.Default
    private List<List<Node>> adjList = new ArrayList<>();
    private int vertices;

    public void addEdge(int source, int destination, int weight) {
        System.out.println("Adding edge from " + source + " to " + destination + " with weight " + weight);
        adjList.get(source).add(new Node(destination, weight));
        adjList.get(destination).add(new Node(source, weight)); // For undirected graph
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class Node {
        private int destination;
        private int weight;
    }
}