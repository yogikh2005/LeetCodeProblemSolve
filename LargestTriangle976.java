import java.util.Arrays;

class Solution {
    public int largestPerimeter(int[] nums) {
        // Step 1: Sort the array
        Arrays.sort(nums);

        // Step 2: Check largest triples first
        for (int i = nums.length - 1; i >= 2; i--) {
            int a = nums[i - 2];
            int b = nums[i - 1];
            int c = nums[i];

            // Triangle inequality
            if (a + b > c) {
                return a + b + c;
            }
        }

        // Step 3: No valid triangle found
        return 0;
    }
}
