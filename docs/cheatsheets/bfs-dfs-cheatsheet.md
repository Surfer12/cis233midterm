# BFS vs DFS Traversal Cheat Sheet

## Visual Example
Consider this graph:
```
         1
       /   \
      2     3
     / \   /  \
    4   5   6
                  \
      7
```

### BFS Traversal
- Order: 1 → 2 → 3 → 4 → 5 → 6 → 7
- Visits nodes level by level (breadth-first)
- Uses a Queue data structure

### DFS Traversal
- Order: 1 → 2 → 4 → 5 → 3 → 6 → 7
- Visits nodes by exploring as far as possible (depth-first)
- Uses a Stack (or recursion)

## Implementation Comparison

### BFS Implementation
```java
void bfs(Node root) {
    if (root == null) return;
    
    Queue<Node> queue = new LinkedList<>();
    Set<Node> visited = new HashSet<>();
    
    queue.offer(root);
    visited.add(root);
    
    while (!queue.isEmpty()) {
        Node current = queue.poll();
        System.out.print(current.val + " ");
        
        for (Node neighbor : current.neighbors) {
            if (!visited.contains(neighbor)) {
                visited.add(neighbor);
                queue.offer(neighbor);
            }
        }
    }
}
```

### DFS Implementation
```java
void dfs(Node root) {
    if (root == null) return;
    
    Set<Node> visited = new HashSet<>();
    dfsRecursive(root, visited);
}

void dfsRecursive(Node node, Set<Node> visited) {
    visited.add(node);
    System.out.print(node.val + " ");
    
    for (Node neighbor : node.neighbors) {
        if (!visited.contains(neighbor)) {
            dfsRecursive(neighbor, visited);
        }
    }
}
```

## Key Differences

| Aspect | BFS | DFS |
|--------|-----|-----|
| Data Structure | Queue | Stack/Recursion |
| Space Complexity | O(w) where w is max width | O(h) where h is height |
| Use Cases | Shortest path, Level-order | Path finding, Tree traversal |
| Traversal Pattern | Layer by layer | Branch by branch |
| Memory Usage | More memory in wide graphs | Less memory in wide graphs |

## Common Applications

### BFS Applications
1. Shortest path in unweighted graph
2. Level-order traversal
3. Peer-to-peer networks
4. Web crawlers
5. GPS Navigation

### DFS Applications
1. Topological sorting
2. Cycle detection
3. Path finding in maze
4. Connected components
5. Solving puzzles

## Time Complexity
Both BFS and DFS have the same time complexity:
- For adjacency list: O(V + E)
- For adjacency matrix: O(V²)
where V = vertices, E = edges

## Tips & Tricks
1. BFS uses more memory but guarantees shortest path in unweighted graphs
2. DFS can get stuck in infinite paths (need cycle detection)
3. BFS is better for searching closer/neighboring nodes
4. DFS is better for searching in deep hierarchies

## Common Pitfalls
1. Forgetting to mark nodes as visited
2. Not handling disconnected components
3. Stack overflow in DFS for deep graphs
4. Memory overflow in BFS for wide graphs
