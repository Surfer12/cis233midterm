package cis233midterm;  
import TreeNode;

// Given the root of a binary tree, write a code that returns  the sum of all left leaves.
 
// A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.
 
// In the tree below, the sum is 24 i.e, 9+15
 
// Explain the time complexity of your solution.


// Time Complexity Analysis:   
// O(n), where n is the number of nodes in the tree
// We visit each node exactly once
// Constant time operations at each node
class SolutionToSumLeftLeaves {
  
    public int sumOfLeftLeaves(TreeNode root) {
        // Base case: if root is null, return 0
        if (root == null) {
            return 0;
        }
        
        // Initialize sum
        int sum = 0;
        
        // Check if left child exists and is a leaf
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }
        
        // Recursively explore left and right subtrees
        sum += sumOfLeftLeaves(root.left);
        sum += sumOfLeftLeaves(root.right);
        
        return sum;
    }
}