
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
class Solution12 {
    int total; // Declaring an instance variable to store the total sum

    public int sumNumbers(TreeNode root) {
        total = 0; // Initialize total to 0
        helper(root, 0); // Call the helper function with initial sum 0
        return total; // Return the total sum of all root-to-leaf paths
    }

    void helper(TreeNode root, int sum) {
        if (root == null) {
            return; // Base case: If the current node is null, return without processing
        }
        
        sum = sum * 10 + root.val; // Update the sum to include the current node's value

        // Check if the current node is a leaf node (both left and right children are null)
        if (root.left == null && root.right == null) {
            total += sum; // If it is a leaf node, add the current sum to the total
            return; // Return from the function
        }

        // Recursively call helper function for the left and right children
        helper(root.left, sum);
        helper(root.right, sum);
    }

    public static void main(String[] args) {
        // Construct the binary tree: [4,9,0,5,1]
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);

        // Create an instance of Solution
        Solution12 solution = new Solution12();

        // Calculate the sum of all root-to-leaf paths
        int sum = solution.sumNumbers(root);

        // Print the result
        System.out.println("Input: root = [4,9,0,5,1]");
        System.out.println("Output: " + sum);
        System.out.println("Explanation:");
        System.out.println("The root-to-leaf path 4->9->5 represents the number 495.");
        System.out.println("The root-to-leaf path 4->9->1 represents the number 491.");
        System.out.println("The root-to-leaf path 4->0 represents the number 40.");
        System.out.println("Therefore, sum = 495 + 491 + 40 = " + sum);
    }
}
// Time complexity: O(n)
// The algorithm visits each node exactly once, so the time complexity is O(n), where n is the number of nodes in the binary tree.

// Space complexity: O(h)
// The space complexity is O(h), where h is the height of the binary tree. This space is used for the recursive call stack, which can go up to the height of the tree in the worst case.

