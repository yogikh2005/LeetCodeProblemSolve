class Solution {
    public int countEven(int num) {
        
        int cnt=0;
        

        for(int i=1;i<=num;i++)
        {   
            int temp=i;
            int sum=0;
            while(temp>0)
            {
                sum+=temp%10;
                temp/=10;
            }
            if (sum %2==0)
                cnt++;        
        }
    return cnt;
    
    }
}
