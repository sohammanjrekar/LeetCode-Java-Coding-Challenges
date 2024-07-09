
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
class Solution13 {
    public int sumNumbers(TreeNode root) {
        // Call the helper function with initial sum 0 and return its result
        return helper(root, 0);
    }

    int helper(TreeNode root, int sum) {
        // Base case: If the current node is null, return 0
        if (root == null) {
            return 0;
        }
        
        // Update the sum to include the current node's value
        sum = sum * 10 + root.val;

        // If the current node is a leaf node (both left and right children are null),
        // return the current sum
        if (root.left == null && root.right == null) {
            return sum;
        }

        // Recursively calculate the sum of all root-to-leaf paths
        // by adding the results from left and right subtrees
        return helper(root.left, sum) + helper(root.right, sum);
    }


    public static void main(String[] args) {
        // Construct the binary tree: [4,9,0,5,1]
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);

        // Create an instance of Solution
        Solution13 solution = new Solution13();

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

