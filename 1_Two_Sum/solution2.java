
import java.util.HashMap;
import java.util.Map;

class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        // Create a HashMap to store the complement of each element and its index
        Map<Integer, Integer> hm = new HashMap<>();

        // Iterate through each element in the array
        for (int i = 0; i < nums.length; i++) {
            // Check if the current element is already a key in the HashMap
            if (hm.containsKey(nums[i])) {
                // If it is, return the index stored in the HashMap and the current index
                return new int[]{hm.get(nums[i]), i};
            }
            // Otherwise, add the complement of the current element (target - nums[i]) and its index to the HashMap
            hm.put(target - nums[i], i);
        }

        // If no such pair is found, return an empty array
        return new int[]{};
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();

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


// Time complexity: O(n)
// The algorithm iterates through the array once, and each lookup and insertion in the HashMap takes O(1) time. Therefore, the overall time complexity is O(n).

// Space complexity: O(n)
// The algorithm uses a HashMap to store up to n elements (in the worst case, when no pair is found). Therefore, the space complexity is O(n).
