class Solution {
    public int reverseBits(int n) {
        
        String binary = String.format("%32s", Integer.toBinaryString(n)).replace(' ', '0');
        String rev="";
        for(int i=binary.length()-1;i>=0;i--)
        {
            rev+=binary.charAt(i);
        }
        return Integer.parseInt(rev,2);
    }
}
