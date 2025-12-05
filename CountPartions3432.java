class Solution {
   public static int countPartitions(int[] nums) {
        
        int sum=0;
        int sum2=0;
        int cnt=0;

        for(int i=0;i<nums.length-1;i++)
        {   sum=0;
            sum2=0;
            for(int j=0;j<=i;j++)
            { 
                sum+=nums[j];
            }
            for(int j=i+1;j<nums.length;j++)
            {
                sum2+=nums[j];
            }
            
            if((sum-sum2)%2==0)
                cnt++;
        }
        return cnt;
    }

}
