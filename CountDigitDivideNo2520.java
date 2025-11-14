class CountDigitDivideNo2520 {
    public int countDigits(int num) {
        
        int temp=num;
        int cnt=0;
        while(num>0)
        {
            int d=num%10;
            if(temp%d==0)
            {cnt++;}
            num/=10;
        }

        return cnt;
    }
}
