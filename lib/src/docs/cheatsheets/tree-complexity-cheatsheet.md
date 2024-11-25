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

Great question! The worst-case time complexity of O(n) for BST operations occurs when the Binary Search Tree becomes severely unbalanced, essentially degenerating into a linked list.

Here's a detailed explanation:

### Worst-Case Scenario: Skewed Tree

Imagine inserting elements in a sorted order:
```
1
 \
  2
   \
    3
     \
      4
       \
        5
```

In this scenario:
- Each new node is added as the right child
- The tree becomes a linear structure (essentially a linked list)
- Height of the tree becomes equal to the number of nodes (n)

### Impact on Operations

1. **Search**: 
   - Best/Average Case (Balanced Tree): O(log n)
   - Worst Case (Skewed Tree): O(n) 
   - You might need to traverse almost all nodes to find a specific element

2. **Insert**: 
   - Best/Average Case (Balanced Tree): O(log n)
   - Worst Case (Skewed Tree): O(n)
   - Each new insertion requires traversing the entire height of the tree

3. **Delete**: 
   - Best/Average Case (Balanced Tree): O(log n)
   - Worst Case (Skewed Tree): O(n)
   - Finding the node to delete takes linear time

### Solution: Self-Balancing Trees

To prevent this worst-case scenario, we use self-balancing trees like:
- AVL Trees
- Red-Black Trees
- Splay Trees

These trees automatically restructure themselves to maintain a balanced structure, ensuring O(log n) operations.

### Example Code Demonstrating Worst Case

```java
// Worst-case insertion creating a skewed tree
Node insert(Node root, int key) {
    if (root == null) return new Node(key);
    
    // Always inserting to the right creates a linear structure
    root.right = insert(root.right, key);
    return root;
}
```

In this implementation, if you insert [1, 2, 3, 4, 5] in order, you'll create a completely right-skewed tree with O(n) complexity for subsequent operations.

The key takeaway is that the efficiency of a BST depends on its structure. A balanced tree provides logarithmic time complexity, while an unbalanced tree can degrade to linear time complexity.

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

Let me break down the difference between O(n log n) and O(log n):

### O(n log n)

1. **Characteristics**:
   - Grows faster than O(log n)
   - Typical of efficient sorting algorithms
   - Common in divide-and-conquer algorithms

2. **Examples**:
   - Merge Sort
   - Heap Sort
   - Quick Sort (average case)

3. **Visualization**:
````
n log n grows much more quickly:
n = 10:   10 * log(10)  ≈ 33
n = 100:  100 * log(100) ≈ 664
n = 1000: 1000 * log(1000) ≈ 9,966
````

### O(log n)

1. **Characteristics**:
   - Very slow growth
   - Typical of divide-and-half algorithms
   - Often seen in binary search or balanced tree operations

2. **Examples**:
   - Binary Search
   - Balanced BST operations
   - Certain recursive algorithms that halve the problem size

3. **Visualization**:
````
log n grows extremely slowly:
n = 10:   log(10)  ≈ 3.3
n = 100:  log(100) ≈ 6.6
n = 1000: log(1000) ≈ 10
````

### Comparison

| Aspect | O(n log n) | O(log n) |
|--------|------------|----------|
| Growth Rate | Linearithmic | Logarithmic |
| Scalability | Slower | Very Fast |
| Typical Use | Sorting, Complex Divide-Conquer | Search, Balanced Trees |

### Practical Analogy

Think of O(n log n) like climbing stairs while solving a puzzle at each step.
Think of O(log n) like taking an express elevator that skips most floors.

### Code Example Illustrating Difference

````python
# O(n log n) - Merge Sort
def merge_sort(arr):
    if len(arr) <= 1:
        return arr
    
    mid = len(arr) // 2
    left = merge_sort(arr[:mid])      # Dividing takes log n
    right = merge_sort(arr[mid:])     # Dividing takes log n
    
    return merge(left, right)         # Merging takes n time

# O(log n) - Binary Search
def binary_search(arr, target):
    left, right = 0, len(arr) - 1
    
    while left <= right:
        mid = (left + right) // 2     # Halving each iteration
        if arr[mid] == target:
            return mid
        elif arr[mid] < target:
            left = mid + 1            # Discard left half
        else:
            right = mid - 1           # Discard right half
    
    return -1
````

### When to Use

- **O(n log n)**: When you need to sort or perform complex divide-and-conquer operations
- **O(log n)**: When you can repeatedly divide the problem space

The key difference is that O(n log n) multiplies the logarithmic factor by n, making it significantly slower for large inputs compared to O(log n).

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
