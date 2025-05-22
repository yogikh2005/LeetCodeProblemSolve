import java.util.*;

public class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] coverage = new int[n + 1];

        // Step 1: Calculate initial coverage using difference array
        for (int[] q : queries) {
            coverage[q[0]] += 1;
            if (q[1] + 1 < n)
                coverage[q[1] + 1] -= 1;
        }

        // Prefix sum to get actual coverage at each index
        for (int i = 1; i < n; i++) {
            coverage[i] += coverage[i - 1];
        }

        // Step 2: Check if possible at all
        for (int i = 0; i < n; i++) {
            if (coverage[i] < nums[i]) {
                return -1;
            }
        }

        // Step 3: Binary search for max queries that can be removed
        int left = 0, right = queries.length;
        int maxRemovable = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (isValid(nums, queries, mid)) {
                maxRemovable = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return maxRemovable;
    }

    private boolean isValid(int[] nums, int[][] queries, int removeCount) {
        int n = nums.length;
        int[] coverage = new int[n + 1];

        // Only use the last (queries.length - removeCount) queries
        for (int i = removeCount; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            coverage[l] += 1;
            if (r + 1 < n)
                coverage[r + 1] -= 1;
        }

        // Accumulate
        for (int i = 1; i < n; i++) {
            coverage[i] += coverage[i - 1];
        }

        for (int i = 0; i < n; i++) {
            if (coverage[i] < nums[i]) return false;
        }

        return true;
    }
}
