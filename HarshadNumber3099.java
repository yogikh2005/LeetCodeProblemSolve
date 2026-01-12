class Solution {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        
        int sum=0;
        int temp=x;
        while(temp>0)
        {
            int d=temp%10;
            sum+=d;
            temp/=10;
        }
        return x%sum == 0?sum: -1;
    }
}
