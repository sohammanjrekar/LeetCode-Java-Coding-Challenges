class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        // Iterate through each element in the array
        for (int i = 0; i < nums.length; i++) {
            // For each element, iterate through the remaining elements
            for (int j = i + 1; j < nums.length; j++) {
                // Check if the sum of the current element and the next element equals the target
                if (nums[i] + nums[j] == target) {
                    // If it does, return the indices of these two elements
                    return new int[]{i, j};
                }
            }
        }
        // If no such pair is found, return an empty array
        return new int[]{};
    }
    
    public static void main(String[] args) {
        Solution1 solution = new Solution1();

        // Example 1
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = solution.twoSum(nums1, target1);
        System.out.println("Example 1: ");
        System.out.println("Input: nums = [2, 7, 11, 15], target = 9");
        System.out.println("Output: [" + result1[0] + "," + result1[1] + "]");
        System.out.println("Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].");

        // Example 2
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = solution.twoSum(nums2, target2);
        System.out.println("Example 2: ");
        System.out.println("Input: nums = [3, 2, 4], target = 6");
        System.out.println("Output: [" + result2[0] + "," + result2[1] + "]");
        System.out.println("Explanation: Because nums[1] + nums[2] == 6, we return [1, 2].");

        // Example 3
        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] result3 = solution.twoSum(nums3, target3);
        System.out.println("Example 3: ");
        System.out.println("Input: nums = [3, 3], target = 6");
        System.out.println("Output: [" + result3[0] + "," + result3[1] + "]");
        System.out.println("Explanation: Because nums[0] + nums[1] == 6, we return [0, 1].");
    }
}

// Time complexity: O(n^2)
// The algorithm uses two nested loops, where the outer loop runs n times and the inner loop runs up to n-1 times in the worst case, resulting in O(n^2) time complexity.

// Space complexity: O(1)
// The algorithm uses a constant amount of extra space, which does not depend on the input size. Therefore, the space complexity is O(1).
