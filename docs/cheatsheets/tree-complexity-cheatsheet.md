# Trees, BSTs, and Complexity Analysis Cheat Sheet

## Tree Fundamentals

### Basic Tree Structure
```
         A          Level 0 (Root)
       /   \
      B     C       Level 1
     / \   / \
    D   E F   G     Level 2
```

### Binary Tree Properties
- Each node has at most 2 children
- Maximum nodes at level n: 2ⁿ
- Maximum nodes in tree of height h: 2ʰ⁺¹ - 1
- Height of perfect binary tree with n nodes: log₂(n + 1) - 1

### Tree Terms
- Root: Top node (A in example)
- Leaf: Node with no children (D, E, F, G)
- Height: Length of path from root to deepest node
- Depth: Length of path from node to root
- Internal Node: Node with at least one child

## Binary Search Tree (BST)

### BST Properties
```
         8          BST Property:
       /   \        - Left subtree < Node
      3    10       - Right subtree > Node 
     / \     \      - No duplicates
    1   6     14    - Inorder traversal gives sorted sequence
```

### BST Operations Time Complexity
| Operation | Average | Worst |
|-----------|---------|-------|
| Search    | O(log n)| O(n)  |
| Insert    | O(log n)| O(n)  |
| Delete    | O(log n)| O(n)  |
| Traverse  | O(n)    | O(n)  |

### Common BST Operations
```java
// Insert
if (root == null) return new Node(key);
if (key < root.val) 
    root.left = insert(root.left, key);
else if (key > root.val)
    root.right = insert(root.right, key);
return root;

// Search
if (root == null || root.val == key) return root;
if (key < root.val) return search(root.left, key);
return search(root.right, key);
```

## Tree Traversals

### Three Main Types
```
         1
       /   \
      2     3
     / \   
    4   5   

Pre-order  : 1-2-4-5-3    (Root-Left-Right)
In-order   : 4-2-5-1-3    (Left-Root-Right)
Post-order : 4-5-2-3-1    (Left-Right-Root)
```

### Implementation
```java
void preorder(Node node) {
    if (node == null) return;
    print(node.val);      // Process root
    preorder(node.left);  // Process left
    preorder(node.right); // Process right
}

void inorder(Node node) {
    if (node == null) return;
    inorder(node.left);   // Process left
    print(node.val);      // Process root
    inorder(node.right);  // Process right
}

void postorder(Node node) {
    if (node == null) return;
    postorder(node.left);  // Process left
    postorder(node.right); // Process right
    print(node.val);       // Process root
}
```

## Big O Complexity Analysis

### Time Complexity
| Complexity | Name        | Example                          |
|------------|-------------|----------------------------------|
| O(1)       | Constant    | Array access                     |
| O(log n)   | Logarithmic | Binary search                    |
| O(n)       | Linear      | Linear search                    |
| O(n log n) | Log Linear  | Merge sort                      |
| O(n²)      | Quadratic   | Nested loops                     |
| O(2ⁿ)      | Exponential | Recursive Fibonacci              |

### Space Complexity Common Cases
1. O(1) - Constant Space:
```java
int sum(int[] arr) {
    int result = 0;  // Single variable
    for(int num : arr) 
        result += num;
    return result;
}
```

2. O(n) - Linear Space:
```java
int[] copyArray(int[] arr) {
    int[] copy = new int[arr.length];  // Space grows with input
    for(int i = 0; i < arr.length; i++)
        copy[i] = arr[i];
    return copy;
}
```

3. O(log n) - Logarithmic Space:
```java
int binarySearch(int[] arr, int target) {
    // Recursive call stack grows logarithmically
    return binarySearchHelper(arr, target, 0, arr.length - 1);
}
```

### Common Tree Operation Complexities

#### Space Complexity
1. Recursive Tree Traversal: O(h) where h is height
   - Best case (balanced): O(log n)
   - Worst case (skewed): O(n)

2. Level Order Traversal: O(w) where w is max width
   - Perfect binary tree: O(n/2) ≈ O(n)

#### Time Complexity
1. Balanced BST:
   - Search/Insert/Delete: O(log n)
   - Traversal: O(n)

2. Unbalanced BST (Worst Case):
   - Search/Insert/Delete: O(n)
   - Traversal: O(n)

## Common Mistakes to Avoid
1. Forgetting base case in recursive implementations
2. Not handling null nodes
3. Confusing pre/in/post-order traversals
4. Assuming BST is always balanced
5. Miscalculating height vs depth

## Interview Tips
1. Always clarify if tree is balanced/unbalanced
2. Consider edge cases: empty tree, single node
3. Mention both recursive and iterative solutions
4. Discuss space-time tradeoffs
5. Know how to convert sorted array to BST
