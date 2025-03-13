class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int left = 1, right = queries.length, ans = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canMakeZero(nums.clone(), queries, mid)) {
                ans = mid;
                right = mid - 1; // Try a smaller k
            } else {
                left = mid + 1; // Increase k
            }
        }
        
        return ans;
    }
    
    private boolean canMakeZero(int[] nums, int[][] queries, int k) {
        int n = nums.length;
        int[] diff = new int[n + 1]; // Difference array
        
        // Apply first k queries
        for (int i = 0; i < k; i++) {
            int l = queries[i][0], r = queries[i][1], val = queries[i][2];
            diff[l] -= val;
            diff[r + 1] += val; // Reset after r
        }
        
        // Apply the difference array and check if nums can be zero
        int curr = 0;
        for (int i = 0; i < n; i++) {
            curr += diff[i]; // Apply range decrement effect
            nums[i] += curr;
            if (nums[i] > 0) return false; // Still positive, not possible
        }
        
        return true;
    }
}
