/*
We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital, like "Google".
Given a string word, return true if the usage of capitals in it is right.

 

Example 1:

Input: word = "USA"
Output: true
Example 2:

Input: word = "FlaG"
Output: false
 

Constraints:

1 <= word.length <= 100
word consists of lowercase and uppercase English letters.
*/
class detectCapitalUse520 
{
    public boolean detectCapitalUse(String word) 
    {
        
        char arr[]=word.toCharArray();
        int u=0,l=0;

        for(int i=0;i<arr.length;i++)
        {
            if((arr[i]>='A')&&(arr[i]<='Z'))
                {
                    u++;
                }
            if((arr[i]>='a')&&arr[i]<='z')
                {
                    l++;
                }
        }
       
        
        if(arr.length==u)
            return true;
        else if(arr.length==l)
            return true;
        else if((arr[0]>='A')&&(arr[0]<='Z')&&(arr.length==(l+1)))//
            return true;
        else 
        return false;
    }
}
