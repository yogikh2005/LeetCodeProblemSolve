class Solution {
    public int maxAscendingSum(int[] nums) {
        int maxSum = nums[0]; // Initialize max sum with first element
        int currentSum = nums[0]; // Start with first element
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                currentSum += nums[i]; // Extend ascending subarray
            } else {
                maxSum = Math.max(maxSum, currentSum); // Update maxSum if needed
                currentSum = nums[i]; // Reset sum to new subarray
            }
        }
        
        return Math.max(maxSum, currentSum); // Return the final max sum
    }
}
/*
Given an array of positive integers nums, return the maximum possible sum of an ascending subarray in nums.

A subarray is defined as a contiguous sequence of numbers in an array.

A subarray [numsl, numsl+1, ..., numsr-1, numsr] is ascending if for all i where l <= i < r, numsi  < numsi+1. Note that a subarray of size 1 is ascending.
*/
