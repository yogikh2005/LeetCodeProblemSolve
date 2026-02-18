class Solution {
    public boolean hasAlternatingBits(int n) {
        
        String binary=Integer.toBinaryString(n);

        boolean flag=true;

        for(int i=0;i<binary.length()-1;i++)
        {
            if(binary.charAt(i)==binary.charAt(i+1))
                {   
                    flag=false;
                }
        }
        return flag;
    }
}
