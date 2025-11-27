class Solution {
    public int differenceOfSum(int[] nums) {
        int dsum=0;
        int esum=0;
        for(int i=0;i<nums.length;i++)
        {
            dsum+=nums[i];
            int temp=nums[i];
            while(temp>0)
            {
                int d=temp%10;
                esum+=d;
                temp/=10;
            }
        }
        return Math.abs(esum-dsum);
    }
}
