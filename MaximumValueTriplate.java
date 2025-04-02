class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long maxVal = 0;
        
        int[] maxRight = new int[n];
        maxRight[n - 1] = nums[n - 1];
        
        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], nums[i]);
        }
        
        int maxLeft = nums[0];
        
        for (int j = 1; j < n - 1; j++) {
            if (maxLeft > nums[j]) {
                long value = (long)(maxLeft - nums[j]) * maxRight[j + 1];
                maxVal = Math.max(maxVal, value);
            }
            maxLeft = Math.max(maxLeft, nums[j]);
        }
        
        return maxVal;
    }
}
