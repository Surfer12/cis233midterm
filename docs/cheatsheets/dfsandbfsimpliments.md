 
   **Example Code:**
   ```java
import java.util.*;

public class DFS {

    // Method to perform Depth-First Search on a graph
    public static List<Integer> dfs(Map<Integer, List<Integer>> graph, int startNode) {
        List<Integer> visitedNodes = new ArrayList<>(); // List to store the order of visited nodes
        Stack<Integer> stack = new Stack<>(); // Stack to keep track of nodes to visit
        Set<Integer> visited = new HashSet<>(); // Set to keep track of visited nodes

        stack.push(startNode); // Push the starting node onto the stack
        visited.add(startNode); // Mark the starting node as visited

        while (!stack.isEmpty()) {
            int currentNode = stack.pop(); // Pop a node from the top of the stack
            visitedNodes.add(currentNode); // Add the popped node to the visited list

            // Iterate over the neighbors of the current node
            for (int neighbor : graph.get(currentNode)) {
                if (!visited.contains(neighbor)) { // If a neighbor hasn't been visited
                    visited.add(neighbor); // Mark the neighbor as visited
                    stack.push(neighbor); // Push the neighbor onto the stack to visit it later
                }
            }
        }

        return visitedNodes; // Return the list of visited nodes in DFS order
    }

    public static void main(String[] args) {
        // Sample graph represented as an adjacency list
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 4, 6));
        graph.put(1, Arrays.asList(0, 2, 7));
        graph.put(2, Arrays.asList(1));
        graph.put(3, Arrays.asList(4, 5));
        graph.put(4, Arrays.asList(0, 3, 8));
        graph.put(5, Arrays.asList(3));
        graph.put(6, Arrays.asList(0, 7));
        graph.put(7, Arrays.asList(1, 6));
        graph.put(8, Arrays.asList(4));

        int startNode = 0; // Starting node for DFS traversal
        List<Integer> dfsTraversal = dfs(graph, startNode); // Perform DFS

        System.out.println("DFS Traversal: " + dfsTraversal); // Print the traversal order
    }
}
```

**Explanation:**

* The `dfs` method takes the graph represented as an adjacency list (`Map<Integer, List<Integer>>`) and the `startNode` as input.
* It uses a `Stack` to store the nodes to be visited and a `Set` to track the visited nodes.
* The algorithm starts by pushing the `startNode` onto the stack and marking it as visited.
* It then iteratively pops nodes from the stack, explores their unvisited neighbors, marks them as visited, and pushes them onto the stack.
* The `main` method creates a sample graph and calls the `dfs` method to perform the traversal.

**Output:**

```
DFS Traversal: [0, 6, 7, 1, 2, 4, 8, 3, 5]
```

This output shows one possible DFS traversal order for the given graph, as DFS can have multiple valid traversals depending on the order in which neighbors are visited.

```java
import java.util.*;

public class GraphTraversal {

    public static void dfsRecursive(Map<Integer, List<Integer>> graph, int currentNode, Set<Integer> visited, List<Integer> visitedNodes) {
        visited.add(currentNode); // Mark the current node as visited
        visitedNodes.add(currentNode); // Add the current node to the visited list

        // Iterate over the neighbors of the current node
        for (int neighbor : graph.get(currentNode)) {
            if (!visited.contains(neighbor)) { // If a neighbor hasn't been visited
                dfsRecursive(graph, neighbor, visited, visitedNodes); // Recursively call DFS on the neighbor
            }
        }
    }

    public static List<Integer> dfs(Map<Integer, List<Integer>> graph, int startNode) {
        List<Integer> visitedNodes = new ArrayList<>(); // List to store the order of visited nodes
        Set<Integer> visited = new HashSet<>(); // Set to keep track of visited nodes

        dfsRecursive(graph, startNode, visited, visitedNodes); // Call the recursive helper function

        return visitedNodes; // Return the list of visited nodes in DFS order
    }

    public static void bfsRecursive(Map<Integer, List<Integer>> graph, Queue<Integer> queue, Set<Integer> visited, List<Integer> visitedNodes) {
        if (queue.isEmpty()) { // Base case: If the queue is empty, return
            return;
        }

        int currentNode = queue.poll(); // Dequeue a node from the front of the queue
        visitedNodes.add(currentNode); // Add the dequeued node to the visited list

        // Iterate over the neighbors of the current node
        for (int neighbor : graph.get(currentNode)) {
            if (!visited.contains(neighbor)) { // If a neighbor hasn't been visited
                visited.add(neighbor); // Mark the neighbor as visited
                queue.offer(neighbor); // Enqueue the neighbor to visit it later
            }
        }

        bfsRecursive(graph, queue, visited, visitedNodes); // Recursively call BFS
    }

    public static List<Integer> bfs(Map<Integer, List<Integer>> graph, int startNode) {
        List<Integer> visitedNodes = new ArrayList<>(); // List to store the order of visited nodes
        Queue<Integer> queue = new LinkedList<>(); // Queue to keep track of nodes to visit
        Set<Integer> visited = new HashSet<>(); // Set to keep track of visited nodes

        queue.offer(startNode); // Add the starting node to the queue
        visited.add(startNode); // Mark the starting node as visited

        bfsRecursive(graph, queue, visited, visitedNodes); // Call the recursive helper function

        return visitedNodes; // Return the list of visited nodes in BFS order
    }

    public static void main(String[] args) {
        // Sample graph represented as an adjacency list
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 4, 6));
        graph.put(1, Arrays.asList(0, 2, 7));
        graph.put(2, Arrays.asList(1));
        graph.put(3, Arrays.asList(4, 5));
        graph.put(4, Arrays.asList(0, 3, 8));
        graph.put(5, Arrays.asList(3));
        graph.put(6, Arrays.asList(0, 7));
        graph.put(7, Arrays.asList(1, 6));
        graph.put(8, Arrays.asList(4));

        int startNode = 0; // Starting node for traversals

        List<Integer> dfsTraversal = dfs(graph, startNode); // Perform DFS
        System.out.println("DFS Traversal: " + dfsTraversal); // Print the DFS traversal order

        List<Integer> bfsTraversal = bfs(graph, startNode); // Perform BFS
        System.out.println("BFS Traversal: " + bfsTraversal); // Print the BFS traversal order
    }
}
```

This code provides recursive implementations for both DFS and BFS. The `dfsRecursive` function uses a helper function to recursively explore the graph in a depth-first manner. The `bfsRecursive` function recursively processes the queue, visiting nodes layer by layer. The `main` method demonstrates how to use these functions with a sample graph.

The DFS traversal order is [0, 1, 2, 3, 4, 5, 6, 7, 8], which corresponds to the order in which the nodes are visited during the DFS traversal. The starting node is 0, and the traversal visits all nodes in this order.

The BFS traversal order is [0, 1, 4, 6, 2, 7, 3, 8, 5], which corresponds to the order in which the nodes are dequeued and explored during the BFS traversal. The starting node is 0, and the traversal visits all nodes in this order.

## Practice Problems

1. Time/Space Complexity:
   - Analyze the complexity of recursive factorial function
   - Compare complexity of iterative vs recursive binary search
   - Determine complexity of tree traversal algorithms
  
2. BST Operations:
   - Convert [1,2,3,4,5] to balanced BST
   - Implement BST deletion
   - Find height of a binary tree

3. Graph Problems:
   - Find shortest path between two vertices
   - Detect cycle in undirected graph
   - Implement graph as adjacency matrix and list

## Study Tips

1. Active Recall:
   - Write algorithms without referring to notes
   - Draw tree structures and perform operations by hand
   - Explain concepts to others

2. Practice Strategies:
   - Implement each algorithm from scratch
   - Use visualization tools for trees and graphs
   - Create test cases to verify implementations

3. Understanding Checks:
   - Can you explain the time/space complexity of each algorithm?
   - Can you draw the step-by-step process of tree traversals?      
   
   **Example Code:**
   ```java
import java.util.*;

public class DFS {

    // Method to perform Depth-First Search on a graph
    public static List<Integer> dfs(Map<Integer, List<Integer>> graph, int startNode) {
        List<Integer> visitedNodes = new ArrayList<>(); // List to store the order of visited nodes
        Stack<Integer> stack = new Stack<>(); // Stack to keep track of nodes to visit
        Set<Integer> visited = new HashSet<>(); // Set to keep track of visited nodes

        stack.push(startNode); // Push the starting node onto the stack
        visited.add(startNode); // Mark the starting node as visited

        while (!stack.isEmpty()) {
            int currentNode = stack.pop(); // Pop a node from the top of the stack
            visitedNodes.add(currentNode); // Add the popped node to the visited list

            // Iterate over the neighbors of the current node
            for (int neighbor : graph.get(currentNode)) {
                if (!visited.contains(neighbor)) { // If a neighbor hasn't been visited
                    visited.add(neighbor); // Mark the neighbor as visited
                    stack.push(neighbor); // Push the neighbor onto the stack to visit it later
                }
            }
        }

        return visitedNodes; // Return the list of visited nodes in DFS order
    }

    public static void main(String[] args) {
        // Sample graph represented as an adjacency list
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 4, 6));
        graph.put(1, Arrays.asList(0, 2, 7));
        graph.put(2, Arrays.asList(1));
        graph.put(3, Arrays.asList(4, 5));
        graph.put(4, Arrays.asList(0, 3, 8));
        graph.put(5, Arrays.asList(3));
        graph.put(6, Arrays.asList(0, 7));
        graph.put(7, Arrays.asList(1, 6));
        graph.put(8, Arrays.asList(4));

        int startNode = 0; // Starting node for DFS traversal
        List<Integer> dfsTraversal = dfs(graph, startNode); // Perform DFS

        System.out.println("DFS Traversal: " + dfsTraversal); // Print the traversal order
    }
}
```

**Explanation:**

* The `dfs` method takes the graph represented as an adjacency list (`Map<Integer, List<Integer>>`) and the `startNode` as input.
* It uses a `Stack` to store the nodes to be visited and a `Set` to track the visited nodes.
* The algorithm starts by pushing the `startNode` onto the stack and marking it as visited.
* It then iteratively pops nodes from the stack, explores their unvisited neighbors, marks them as visited, and pushes them onto the stack.
* The `main` method creates a sample graph and calls the `dfs` method to perform the traversal.

**Output:**

```
DFS Traversal: [0, 6, 7, 1, 2, 4, 8, 3, 5]
```

This output shows one possible DFS traversal order for the given graph, as DFS can have multiple valid traversals depending on the order in which neighbors are visited.

```java
import java.util.*;

public class GraphTraversal {

    public static void dfsRecursive(Map<Integer, List<Integer>> graph, int currentNode, Set<Integer> visited, List<Integer> visitedNodes) {
        visited.add(currentNode); // Mark the current node as visited
        visitedNodes.add(currentNode); // Add the current node to the visited list

        // Iterate over the neighbors of the current node
        for (int neighbor : graph.get(currentNode)) {
            if (!visited.contains(neighbor)) { // If a neighbor hasn't been visited
                dfsRecursive(graph, neighbor, visited, visitedNodes); // Recursively call DFS on the neighbor
            }
        }
    }

    public static List<Integer> dfs(Map<Integer, List<Integer>> graph, int startNode) {
        List<Integer> visitedNodes = new ArrayList<>(); // List to store the order of visited nodes
        Set<Integer> visited = new HashSet<>(); // Set to keep track of visited nodes

        dfsRecursive(graph, startNode, visited, visitedNodes); // Call the recursive helper function

        return visitedNodes; // Return the list of visited nodes in DFS order
    }

    public static void bfsRecursive(Map<Integer, List<Integer>> graph, Queue<Integer> queue, Set<Integer> visited, List<Integer> visitedNodes) {
        if (queue.isEmpty()) { // Base case: If the queue is empty, return
            return;
        }

        int currentNode = queue.poll(); // Dequeue a node from the front of the queue
        visitedNodes.add(currentNode); // Add the dequeued node to the visited list

        // Iterate over the neighbors of the current node
        for (int neighbor : graph.get(currentNode)) {
            if (!visited.contains(neighbor)) { // If a neighbor hasn't been visited
                visited.add(neighbor); // Mark the neighbor as visited
                queue.offer(neighbor); // Enqueue the neighbor to visit it later
            }
        }

        bfsRecursive(graph, queue, visited, visitedNodes); // Recursively call BFS
    }

    public static List<Integer> bfs(Map<Integer, List<Integer>> graph, int startNode) {
        List<Integer> visitedNodes = new ArrayList<>(); // List to store the order of visited nodes
        Queue<Integer> queue = new LinkedList<>(); // Queue to keep track of nodes to visit
        Set<Integer> visited = new HashSet<>(); // Set to keep track of visited nodes

        queue.offer(startNode); // Add the starting node to the queue
        visited.add(startNode); // Mark the starting node as visited

        bfsRecursive(graph, queue, visited, visitedNodes); // Call the recursive helper function

        return visitedNodes; // Return the list of visited nodes in BFS order
    }

    public static void main(String[] args) {
        // Sample graph represented as an adjacency list
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 4, 6));
        graph.put(1, Arrays.asList(0, 2, 7));
        graph.put(2, Arrays.asList(1));
        graph.put(3, Arrays.asList(4, 5));
        graph.put(4, Arrays.asList(0, 3, 8));
        graph.put(5, Arrays.asList(3));
        graph.put(6, Arrays.asList(0, 7));
        graph.put(7, Arrays.asList(1, 6));
        graph.put(8, Arrays.asList(4));

        int startNode = 0; // Starting node for traversals

        List<Integer> dfsTraversal = dfs(graph, startNode); // Perform DFS
        System.out.println("DFS Traversal: " + dfsTraversal); // Print the DFS traversal order

        List<Integer> bfsTraversal = bfs(graph, startNode); // Perform BFS
        System.out.println("BFS Traversal: " + bfsTraversal); // Print the BFS traversal order
    }
}
```

This code provides recursive implementations for both DFS and BFS. The `dfsRecursive` function uses a helper function to recursively explore the graph in a depth-first manner. The `bfsRecursive` function recursively processes the queue, visiting nodes layer by layer. The `main` method demonstrates how to use these functions with a sample graph.

The DFS traversal order is [0, 1, 2, 3, 4, 5, 6, 7, 8], which corresponds to the order in which the nodes are visited during the DFS traversal. The starting node is 0, and the traversal visits all nodes in this order.

The BFS traversal order is [0, 1, 4, 6, 2, 7, 3, 8, 5], which corresponds to the order in which the nodes are dequeued and explored during the BFS traversal. The starting node is 0, and the traversal visits all nodes in this order.

## Practice Problems

1. Time/Space Complexity:
   - Analyze the complexity of recursive factorial function
   - Compare complexity of iterative vs recursive binary search
   - Determine complexity of tree traversal algorithms
  
2. BST Operations:
   - Convert [1,2,3,4,5] to balanced BST
   - Implement BST deletion
   - Find height of a binary tree

3. Graph Problems:
   - Find shortest path between two vertices
   - Detect cycle in undirected graph
   - Implement graph as adjacency matrix and list

## Study Tips

1. Active Recall:
   - Write algorithms without referring to notes
   - Draw tree structures and perform operations by hand
   - Explain concepts to others

2. Practice Strategies:
   - Implement each algorithm from scratch
   - Use visualization tools for trees and graphs
   - Create test cases to verify implementations

3. Understanding Checks:
   - Can you explain the time/space complexity of each algorithm?
   - Can you draw the step-by-step process of tree traversals?      
   
   **Example Code:**
   ```java
import java.util.*;

public class DFS {

    // Method to perform Depth-First Search on a graph
    public static List<Integer> dfs(Map<Integer, List<Integer>> graph, int startNode) {
        List<Integer> visitedNodes = new ArrayList<>(); // List to store the order of visited nodes
        Stack<Integer> stack = new Stack<>(); // Stack to keep track of nodes to visit
        Set<Integer> visited = new HashSet<>(); // Set to keep track of visited nodes

        stack.push(startNode); // Push the starting node onto the stack
        visited.add(startNode); // Mark the starting node as visited

        while (!stack.isEmpty()) {
            int currentNode = stack.pop(); // Pop a node from the top of the stack
            visitedNodes.add(currentNode); // Add the popped node to the visited list

            // Iterate over the neighbors of the current node
            for (int neighbor : graph.get(currentNode)) {
                if (!visited.contains(neighbor)) { // If a neighbor hasn't been visited
                    visited.add(neighbor); // Mark the neighbor as visited
                    stack.push(neighbor); // Push the neighbor onto the stack to visit it later
                }
            }
        }

        return visitedNodes; // Return the list of visited nodes in DFS order
    }

    public static void main(String[] args) {
        // Sample graph represented as an adjacency list
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 4, 6));
        graph.put(1, Arrays.asList(0, 2, 7));
        graph.put(2, Arrays.asList(1));
        graph.put(3, Arrays.asList(4, 5));
        graph.put(4, Arrays.asList(0, 3, 8));
        graph.put(5, Arrays.asList(3));
        graph.put(6, Arrays.asList(0, 7));
        graph.put(7, Arrays.asList(1, 6));
        graph.put(8, Arrays.asList(4));

        int startNode = 0; // Starting node for DFS traversal
        List<Integer> dfsTraversal = dfs(graph, startNode); // Perform DFS

        System.out.println("DFS Traversal: " + dfsTraversal); // Print the traversal order
    }
}
```

**Explanation:**

* The `dfs` method takes the graph represented as an adjacency list (`Map<Integer, List<Integer>>`) and the `startNode` as input.
* It uses a `Stack` to store the nodes to be visited and a `Set` to track the visited nodes.
* The algorithm starts by pushing the `startNode` onto the stack and marking it as visited.
* It then iteratively pops nodes from the stack, explores their unvisited neighbors, marks them as visited, and pushes them onto the stack.
* The `main` method creates a sample graph and calls the `dfs` method to perform the traversal.

**Output:**

```
DFS Traversal: [0, 6, 7, 1, 2, 4, 8, 3, 5]
```

This output shows one possible DFS traversal order for the given graph, as DFS can have multiple valid traversals depending on the order in which neighbors are visited.

```java
import java.util.*;

public class GraphTraversal {

    public static void dfsRecursive(Map<Integer, List<Integer>> graph, int currentNode, Set<Integer> visited, List<Integer> visitedNodes) {
        visited.add(currentNode); // Mark the current node as visited
        visitedNodes.add(currentNode); // Add the current node to the visited list

        // Iterate over the neighbors of the current node
        for (int neighbor : graph.get(currentNode)) {
            if (!visited.contains(neighbor)) { // If a neighbor hasn't been visited
                dfsRecursive(graph, neighbor, visited, visitedNodes); // Recursively call DFS on the neighbor
            }
        }
    }

    public static List<Integer> dfs(Map<Integer, List<Integer>> graph, int startNode) {
        List<Integer> visitedNodes = new ArrayList<>(); // List to store the order of visited nodes
        Set<Integer> visited = new HashSet<>(); // Set to keep track of visited nodes

        dfsRecursive(graph, startNode, visited, visitedNodes); // Call the recursive helper function

        return visitedNodes; // Return the list of visited nodes in DFS order
    }

    public static void bfsRecursive(Map<Integer, List<Integer>> graph, Queue<Integer> queue, Set<Integer> visited, List<Integer> visitedNodes) {
        if (queue.isEmpty()) { // Base case: If the queue is empty, return
            return;
        }

        int currentNode = queue.poll(); // Dequeue a node from the front of the queue
        visitedNodes.add(currentNode); // Add the dequeued node to the visited list

        // Iterate over the neighbors of the current node
        for (int neighbor : graph.get(currentNode)) {
            if (!visited.contains(neighbor)) { // If a neighbor hasn't been visited
                visited.add(neighbor); // Mark the neighbor as visited
                queue.offer(neighbor); // Enqueue the neighbor to visit it later
            }
        }

        bfsRecursive(graph, queue, visited, visitedNodes); // Recursively call BFS
    }

    public static List<Integer> bfs(Map<Integer, List<Integer>> graph, int startNode) {
        List<Integer> visitedNodes = new ArrayList<>(); // List to store the order of visited nodes
        Queue<Integer> queue = new LinkedList<>(); // Queue to keep track of nodes to visit
        Set<Integer> visited = new HashSet<>(); // Set to keep track of visited nodes

        queue.offer(startNode); // Add the starting node to the queue
        visited.add(startNode); // Mark the starting node as visited

        bfsRecursive(graph, queue, visited, visitedNodes); // Call the recursive helper function

        return visitedNodes; // Return the list of visited nodes in BFS order
    }

    public static void main(String[] args) {
        // Sample graph represented as an adjacency list
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 4, 6));
        graph.put(1, Arrays.asList(0, 2, 7));
        graph.put(2, Arrays.asList(1));
        graph.put(3, Arrays.asList(4, 5));
        graph.put(4, Arrays.asList(0, 3, 8));
        graph.put(5, Arrays.asList(3));
        graph.put(6, Arrays.asList(0, 7));
        graph.put(7, Arrays.asList(1, 6));
        graph.put(8, Arrays.asList(4));

        int startNode = 0; // Starting node for BFS traversal
        List<Integer> bfsTraversal = bfs(graph, startNode); // Perform BFS        
        System.out.println("BFS Traversal: " + bfsTraversal); // Print the BFS traversal order
    }
}
```

This code provides recursive implementations for both DFS and BFS. The `dfsRecursive` function uses a helper function to recursively explore the graph in a depth-first manner. The `bfsRecursive` function recursively processes the queue, visiting nodes layer by layer. The `main` method demonstrates how to use these functions with a sample graph.

The DFS traversal order is [0, 1, 2, 3, 4, 5, 6, 7, 8], which corresponds to the order in which the nodes are visited during the DFS traversal. The starting node is 0, and the traversal visits all nodes in this order.

The BFS traversal order is [0, 1, 4, 6, 2, 7, 3, 8, 5], which corresponds to the order in which the nodes are dequeued and explored during the BFS traversal. The starting node is 0, and the traversal visits all nodes in this order.

## Practice Problems

1. Time/Space Complexity:
   - Analyze the complexity of recursive factorial function
   - Compare complexity of iterative vs recursive binary search
   - Determine complexity of tree traversal algorithms
  
2. BST Operations:
   - Convert [1,2,3,4,5] to balanced BST
   - Implement BST deletion
   - Find height of a binary tree

3. Graph Problems:
   - Find shortest path between two vertices
   - Detect cycle in undirected graph
   - Implement graph as adjacency matrix and list