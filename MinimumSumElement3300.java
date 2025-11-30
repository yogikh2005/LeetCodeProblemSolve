class Solution {
    public static int minElement(int[] nums) {
        int min=Integer.MAX_VALUE;
        int temp=0;
        for(int n:nums)
        {   
            temp=0;
            while(n>0)
            {
                temp+=n%10;
                n/=10;
           }

           if(temp<min)
               min=temp;
        }
        return min;
    }

}
