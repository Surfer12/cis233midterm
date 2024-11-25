// Given the following tree, draw the tree and write the pre-order, post-order, and in-order traversals.
         A
       /   \
      B     C
     / \     \
    D   E     F
   /         / \
  G         H   I


// Pre-order traversal (Root -> Left -> Right):
// Pre-order (Root -> Left -> Right):
// Start at root (A)
// Visit left subtree (B and its children)
// Visit right subtree (C and its children)
// A - B - D - G - E - C - F - H - I

// Post-order traversal (Left -> Right -> Root):
// Post-order (Left -> Right -> Root):
// Visit left subtree first (B's subtree)
// Visit right subtree (C's subtree)
// Visit root (A) last
// G - D - E - B - H - I - F - C - A



// In-order (Left -> Root -> Right):
// Visit left subtree (B's subtree)
// Visit root (A)
// Visit right subtree (C's subtree)
// In-order traversal (Left -> Root -> Right):
// D - G - B - E - A - C - H - F - I

