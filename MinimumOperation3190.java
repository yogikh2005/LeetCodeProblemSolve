class Solution {
    public int minimumOperations(int[] nums) {
        int total=0;
        for(int i=0;i<nums.length;i++)
        {
            int r=nums[i]%3;
            if(r!=0)
                total+=Math.min(r,3-r);
        }
        return total;
    }
}
