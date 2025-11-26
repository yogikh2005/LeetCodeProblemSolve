class Solution {
   public static int[] smallerNumbersThanCurrent(int[] nums) {
         int s=nums.length;
         int ans[]=new int[s];
        //8 1 2 2 3
         for(int i=0;i<s;i++)
         { int t=0;
                for(int j=0;j<s;j++)
             {
                 if(nums[j]<nums[i])
                 {      
                     t++;
                 }
             } 
             ans[i]=t;
         }
         return ans;
        
    }
}
