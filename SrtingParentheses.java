/*
A parentheses string is a non-empty string consisting only of '(' and ')'. It is valid if any of the following conditions is true:

It is ().
It can be written as AB (A concatenated with B), where A and B are valid parentheses strings.
It can be written as (A), where A is a valid parentheses string.
You are given a parentheses string s and a string locked, both of length n. locked is a binary string consisting only of '0's and '1's. For each index i of locked,

If locked[i] is '1', you cannot change s[i].
But if locked[i] is '0', you can change s[i] to either '(' or ')'.
Return true if you can make s a valid parentheses string. Otherwise, return false.
*/
class SrtingParentheses  {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        // If n is odd, it's impossible to have a valid parentheses string
        if (n % 2 != 0) return false;
        
        int openBalance = 0, flexibleBalance = 0;
        
        // Forward pass: Check if there are enough open or flexible positions
        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '1') {
                openBalance += (s.charAt(i) == '(' ? 1 : -1);
            } else {
                flexibleBalance++;
            }
            
            if (openBalance + flexibleBalance < 0) return false;
        }
        
        int closeBalance = 0;
        flexibleBalance = 0;
        
        // Backward pass: Check if there are enough close or flexible positions
        for (int i = n - 1; i >= 0; i--) {
            if (locked.charAt(i) == '1') {
                closeBalance += (s.charAt(i) == ')' ? 1 : -1);
            } else {
                flexibleBalance++;
            }
            
            if (closeBalance + flexibleBalance < 0) return false;
        }
        
        return true;
    }
}
