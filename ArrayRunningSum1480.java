class Solution {
    public int[] runningSum(int[] nums) {
        int temp=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            temp+=nums[i];
            nums[i]=temp;
        }
        return nums;
    }
}
