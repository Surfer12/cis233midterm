
        A
       /   \
      B     C
     /     / \
    D    E   F
         /   /  \
        G   H    I

// Pre-order traversal (Root -> Left -> Right):
// Start at root (A) A -  
// Visit left subtree (B and its children) B - D - 
// Visit right subtree (C and its children) C - E - G - F - H - I
// A - B - D - C - E - G - F - H - I

// Post-order traversal (Left -> Right -> Root)
// Start at left subtree (B's subtree) D - // is child of B
// continue to processes left subtree (B's subtree) B - 
// Visit root (A) last so skip A
// continue to processes right subtree (C's subtree) G - E - H - I - F - C - 
// visit root (A) last
// D-B-G-E-H-I-F-C-A

// In-order (Left -> Root -> Right):
// D-B-A-G-E-C-H-F-I