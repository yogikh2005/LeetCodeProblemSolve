class Solution {
    public int findNumbers(int[] nums) {
        
        int cnt=0;
        int d=0;
        for(int i=0;i<nums.length;i++)
        {
            int temp=nums[i];
            d=0;
            while(temp>0)
            {
                d++;
                temp/=10;
            }
            if(d%2==0)
                cnt++;
        }
        return cnt;
    }
}
