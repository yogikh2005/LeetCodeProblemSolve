
import java.util.Arrays;

class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums); // Step 1: Sort the array
        int count = 1;      // At least one subsequence
        int start = nums[0]; // First element of the first subsequence

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - start > k) {
                count++;           // Start a new subsequence
                start = nums[i];   // Reset start to new subsequence's first element
            }
        }

        return count;
    }
}
