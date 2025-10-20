class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder s1=new StringBuilder();
        for(char ch:s.toCharArray())
        {
        if(Character.isLetterOrDigit(ch)){
        
            s1.append(Character.toLowerCase(ch));
        }}
    StringBuilder s2=new StringBuilder(s1.toString());
    s1.reverse();
    return s1.toString().equals(s2.toString());
    
    
    }

}
