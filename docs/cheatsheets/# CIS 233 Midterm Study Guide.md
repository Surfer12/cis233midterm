# CIS 233 Midterm Study Guide

## 1. Algorithm Analysis Practice

### Time Complexity Analysis
Practice analyzing these common scenarios:
1. Simple loops: O(n)
```java
for(int i = 0; i < n; i++) {
    // single operation
}
```

2. Nested loops: O(n²)
```java
for(int i = 0; i < n; i++) {
    for(int j = 0; j < n; j++) {
        // single operation
    }
}
```

3. Logarithmic complexity: O(log n)
```java
while(n > 1) {
    n = n/2;
}
```

### Space Complexity Practice
Remember: Space Complexity = Auxiliary Space + Input Space

Common patterns:
1. Constant space O(1):
- Fixed number of variables
- No extra data structures

2. Linear space O(n):
- Arrays/Lists proportional to input
- Recursive call stack depth n

3. Logarithmic space O(log n):
- Binary search recursive stack
- Divide and conquer algorithms

## 2. Tree Operations Practice

### Binary Search Tree Implementation
```java
class Node {
    int data;
    Node left, right;
    
    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class BST {
    Node root;
    
    // Insert method
    public void insert(int data) {
        root = insertRec(root, data);
    }
    
    private Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        
        if (data < root.data)
            root.left = insertRec(root.left, data);
        else if (data > root.data)
            root.right = insertRec(root.right, data);
            
        return root;
    }
}
```

### Tree Traversal Methods
```java
// Pre-order traversal
void preorder(Node node) {
    if (node == null) return;
    
    System.out.print(node.data + " ");  // Process root
    preorder(node.left);                // Process left subtree
    preorder(node.right);               // Process right subtree
}

// In-order traversal
void inorder(Node node) {
    if (node == null) return;
    
    inorder(node.left);                 // Process left subtree
    System.out.print(node.data + " ");  // Process root
    inorder(node.right);                // Process right subtree
}

// Post-order traversal
void postorder(Node node) {
    if (node == null) return;
    
    postorder(node.left);               // Process left subtree
    postorder(node.right);              // Process right subtree
    System.out.print(node.data + " ");  // Process root
}
```

## 3. Graph Algorithms Practice

### BFS Implementation
```java
void bfs(int startVertex) {
    boolean[] visited = new boolean[V];
    Queue<Integer> queue = new LinkedList<>();
    
    visited[startVertex] = true;
    queue.offer(startVertex);
    
    while (!queue.isEmpty()) {
        int vertex = queue.poll();
        System.out.print(vertex + " ");
        
        for (int neighbor : adjList[vertex]) {
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                queue.offer(neighbor);
            }
        }
    }
}
```

### Dijkstra's Algorithm Steps
1. Initialize distances array (infinity for all vertices except source)
2. Create priority queue
3. While priority queue is not empty:
   - Get vertex with minimum distance
   - For each neighbor:
     - Calculate new distance
     - Update if new distance is shorter

I'll provide pseudocode for the requested traversal algorithms:

### Depth-First Search (DFS) Pseudocode
```
function DFS(graph, startVertex):
    // Create a set to track visited vertices
    visited = empty set
    
    // Helper function for recursive DFS
    function explore(vertex):
        // Mark current vertex as visited
        add vertex to visited
        print vertex
        
        // Explore all unvisited neighbors
        for each neighbor of vertex in graph:
            if neighbor is not in visited:
                explore(neighbor)
    
    // Start DFS from the start vertex
    explore(startVertex)
```

### Breadth-First Search (BFS) Pseudocode
```
function BFS(graph, startVertex):
    // Create a queue for vertices to visit
    queue = empty queue
    
    // Create a set to track visited vertices
    visited = empty set
    
    // Add start vertex to queue and mark as visited
    add startVertex to queue
    add startVertex to visited
    
    while queue is not empty:
        // Dequeue a vertex
        currentVertex = remove first vertex from queue
        print currentVertex
        
        // Explore all unvisited neighbors
        for each neighbor of currentVertex in graph:
            if neighbor is not in visited:
                add neighbor to queue
                add neighbor to visited
```

### Binary Search Tree Traversals Pseudocode

#### Preorder Traversal (Root-Left-Right)
```
function preorderTraversal(node):
    if node is null:
        return
    
    // Process root first
    print node.value
    
    // Then left subtree
    preorderTraversal(node.left)
    
    // Then right subtree
    preorderTraversal(node.right)
```

#### Inorder Traversal (Left-Root-Right)
```
function inorderTraversal(node):
    if node is null:
        return
    
    // First traverse left subtree
    inorderTraversal(node.left)
    
    // Then process root
    print node.value
    
    // Then traverse right subtree
    inorderTraversal(node.right)
```

#### Postorder Traversal (Left-Right-Root)
```
function postorderTraversal(node):
    if node is null:
        return
    
    // First traverse left subtree
    postorderTraversal(node.left)
    
    // Then traverse right subtree
    postorderTraversal(node.right)
    
    // Finally process root
    print node.value
```

Key Differences Explained:
- DFS explores as far as possible along each branch before backtracking
- BFS explores all neighbors at the current depth before moving to the next depth level
- Tree traversals differ in the order of processing the current node relative to its left and right subtrees:
  - Preorder: Root → Left → Right
  - Inorder: Left → Root → Right
  - Postorder: Left → Right → Root

These pseudocode examples provide a clear, language-agnostic representation of the traversal algorithms, highlighting their core logic and structure.

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
   - Can you implement graph algorithms without references?