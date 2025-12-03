class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        // We reduce from full length down to 1
        for (int length = n; length > 1; length--) {
            for (int i = 0; i < length - 1; i++) {
                nums[i] = (nums[i] + nums[i + 1]) % 10;
            }
        }
        return nums[0];
    }
}
