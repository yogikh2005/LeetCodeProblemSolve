import java.util.Arrays;

class Solution {
    public int maximumCount(int[] nums) {
        int pos = nums.length - firstPositiveIndex(nums);
        int neg = firstNegativeIndex(nums);
        return Math.max(pos, neg);
    }

    // Binary search to find the first index where nums[i] > 0
    private int firstPositiveIndex(int[] nums) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > 0) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // Binary search to find the first index where nums[i] >= 0
    private int firstNegativeIndex(int[] nums) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= 0) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
