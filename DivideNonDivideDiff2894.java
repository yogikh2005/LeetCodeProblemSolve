class Solution {
    public int differenceOfSums(int n, int m) {
        int dsum=0;
        int  unsum=0;
        for(int i=1;i<=n;i++)
        {
            if(i%m==0)
            {
                dsum+=i;
            }
            else
            {
                unsum+=i;
            }
        }
        return (unsum-dsum);
    }
}
