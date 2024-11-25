

package cis233midterm;
import cis233midterm.SolutionToSumLeftLeaves;
import cis233midterm.TreeNode;  
import org.junit.Test;  
import static org.junit.Assert.*;
 
// Given the root of a binary tree, write a code that returns  the sum of all left leaves.  

public class SumOfLeftLeavesTest {
    
    @Test
    public void testEmptyTree() {
        SolutionToSumLeftLeaves solution = new SolutionToSumLeftLeaves();
        TreeNode root = null;
        assertEquals(0, solution.sumOfLeftLeaves(root));
    }
    
    @Test
    public void testSingleNodeTree() {
        SolutionToSumLeftLeaves solution = new SolutionToSumLeftLeaves();
        TreeNode root = new TreeNode(5);
        assertEquals(0, solution.sumOfLeftLeaves(root));
    }
    
    @Test
    public void testTreeWithOnlyLeftLeaf() {
        SolutionToSumLeftLeaves solution = new SolutionToSumLeftLeaves();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        assertEquals(9, solution.sumOfLeftLeaves(root));
    }
    
    @Test
    public void testTreeWithMultipleLeftLeaves() {
        SolutionToSumLeftLeaves solution = new SolutionToSumLeftLeaves();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        assertEquals(24, solution.sumOfLeftLeaves(root));
    }
    
    @Test
    public void testTreeWithNoLeftLeaves() {
        SolutionToSumLeftLeaves solution = new SolutionToSumLeftLeaves();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        assertEquals(0, solution.sumOfLeftLeaves(root));
    }
    
    @Test
    public void testComplexTree() {
        SolutionToSumLeftLeaves solution = new SolutionToSumLeftLeaves();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        assertEquals(10, solution.sumOfLeftLeaves(root));
    }
} 