class Solution {
    public int smallestIndex(int[] nums) {
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            int temp = nums[i];
            
            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }

            if (sum == i) {
                ans = Math.min(ans, i);
            }
        }


        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }
}
