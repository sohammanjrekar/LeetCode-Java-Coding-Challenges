import java.util.*;

// Definition for a binary tree node
class TreeNode {
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

class Solution15 {

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        // Get the depth of the left and right subtrees
        int left = getDepth(root.left);
        int right = getDepth(root.right);

        // If the depths of left and right subtrees are equal, root is the subtree with all deepest nodes
        if (left == right) {
            return root;
        }

        // If left depth is greater than right depth, recurse on the left subtree
        if (left > right) {
            return subtreeWithAllDeepest(root.left);
        } else { // Otherwise, recurse on the right subtree
            return subtreeWithAllDeepest(root.right);
        }
    }

    // Helper function to calculate the depth of a subtree
    int getDepth(TreeNode root) {
        // Base case: if node is null, return depth 0
        if (root == null) {
            return 0;
        }

        // Recursively calculate the depth of left and right subtrees
        return 1 + Math.max(getDepth(root.left), getDepth(root.right));
    }

    // Utility function to print values of nodes in a subtree (in-order traversal)
    static void printTree(TreeNode node) {
        if (node == null) return;
        printTree(node.left);
        System.out.print(node.val + " ");
        printTree(node.right);
    }
    public static void main(String[] args) {
        // Construct the binary tree [3,5,1,6,2,0,8,null,null,7,4]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        // Create an instance of Solution14
        Solution15 solution = new Solution15();

        // Call the subtreeWithAllDeepest method to find the subtree with all deepest nodes
        TreeNode result = solution.subtreeWithAllDeepest(root);

        // Print the values of the nodes in the resulting subtree
        printTree(result); // Output: [2, 7, 4]
    }
}
