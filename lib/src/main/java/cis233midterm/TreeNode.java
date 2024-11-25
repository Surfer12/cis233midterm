// Given the root of a binary tree, write a code that returns  the sum of all left leaves.
 
// A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.
 
// In the tree below, the sum is 24 i.e, 9+15
 
// Explain the time complexity of your solution.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}