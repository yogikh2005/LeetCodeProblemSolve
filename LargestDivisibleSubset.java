import java.util.*;

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums); // Step 1: Sort the array
        int n = nums.length;
        int[] dp = new int[n]; // dp[i] = size of largest subset ending at nums[i]
        int[] prev = new int[n]; // prev[i] = previous index in the subset
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        int maxIndex = 0; // Index of largest subset's last element

        // Step 2: Fill dp[] and prev[]
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > dp[maxIndex]) {
                maxIndex = i;
            }
        }

        // Step 3: Reconstruct subset
        List<Integer> result = new ArrayList<>();
        for (int i = maxIndex; i >= 0; i = prev[i]) {
            result.add(nums[i]);
            if (prev[i] == -1) break;
        }

        Collections.reverse(result); // Optional: To return in increasing order
        return result;
    }
}
