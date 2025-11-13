class smallEvenMultiple2413 {
    public int smallestEvenMultiple(int n) {
        int temp=0;
        for(int i=1;i<=150;i++)
        {
            temp= n*i;
            if((temp%2==0) && (temp%n==0))
            {    break;
                
            
            }
        }
        return temp;
    }
}
/*
2413. Smallest Even Multiple
Easy
Topics
premium lock icon
Companies
Hint
Given a positive integer n, return the smallest positive integer that is a multiple of both 2 and n.
 

Example 1:

Input: n = 5
Output: 10
Explanation: The smallest multiple of both 5 and 2 is 10.
Example 2:

Input: n = 6
Output: 6
Explanation: The smallest multiple of both 6 and 2 is 6. Note that a number is a multiple of itself.
 

Constraints:

1 <= n <= 150
*/
